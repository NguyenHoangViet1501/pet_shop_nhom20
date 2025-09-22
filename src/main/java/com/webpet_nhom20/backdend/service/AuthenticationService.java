package com.webpet_nhom20.backdend.service;

import com.nimbusds.jose.JOSEException;
import com.webpet_nhom20.backdend.dto.request.AuthenticationRequest;
import com.webpet_nhom20.backdend.dto.request.IntrospectRequest;
import com.webpet_nhom20.backdend.dto.response.AuthenticationResponse;
import com.webpet_nhom20.backdend.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {


    public AuthenticationResponse authenticate(AuthenticationRequest request);
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
