package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {
    Optional<CartItems> findByCartIdAndProductVariantId(Integer cartId, Integer variantId);

    List<CartItems> findByCartId(Integer cartId);

    void deleteByCartId(Integer cartId);

    Optional<CartItems> findByIdAndCart_User_Id(Integer id, Integer userId);
}
