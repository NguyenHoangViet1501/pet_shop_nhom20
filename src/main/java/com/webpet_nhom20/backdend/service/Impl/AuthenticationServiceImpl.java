package com.webpet_nhom20.backdend.service.Impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.webpet_nhom20.backdend.dto.request.AuthenticationRequest;
import com.webpet_nhom20.backdend.dto.request.IntrospectRequest;
import com.webpet_nhom20.backdend.dto.response.AuthenticationResponse;
import com.webpet_nhom20.backdend.dto.response.IntrospectResponse;
import com.webpet_nhom20.backdend.entity.User;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.repository.UserRepository;
import com.webpet_nhom20.backdend.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    private UserRepository userRepository;

    @Value("${signerKey}")
    private String signerKey;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public IntrospectResponse introspect(IntrospectRequest request) throws ParseException, JOSEException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(signerKey.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }





    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));
        boolean match10 = passwordEncoder.matches(request.getPassword(), user.getPassword());
        boolean authenticated = passwordEncoder.matches(request.getPassword()
                ,user.getPassword());
        if(!authenticated) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        var token = generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

        private String generateToken(User user){
            JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
            JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                    .subject(user.getUsername())
                    .issuer("Bao")
                    .issueTime(new Date())
                    .expirationTime(new Date(Instant.now().plus(2, ChronoUnit.HOURS).toEpochMilli()))
                    .claim("scope" , buildScope(user))
                    .build();
            Payload payload = new Payload(jwtClaimsSet.toJSONObject());
            JWSObject jwsObject = new JWSObject(header, payload);


            try {
                jwsObject.sign(new MACSigner(signerKey.getBytes()));
                return jwsObject.serialize();
            } catch (JOSEException e) {
                log.error("Cannot generate token:", e);
                throw  new RuntimeException();
            }


        }

    private String buildScope(User user) {
        return user.getRoles();
    }

}

