package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.config.JwtTokenProvider;
import com.webpet_nhom20.backdend.dto.request.Order.OrderRequest;
import com.webpet_nhom20.backdend.dto.request.OrderItem.OrderItemRequest;
import com.webpet_nhom20.backdend.dto.response.Order.OrderResponse;
import com.webpet_nhom20.backdend.dto.response.OrderItem.OrderItemResponse;
import com.webpet_nhom20.backdend.entity.Order;
import com.webpet_nhom20.backdend.entity.OrderItems;
import com.webpet_nhom20.backdend.entity.ProductVariants;
import com.webpet_nhom20.backdend.enums.OrderStatus;
import com.webpet_nhom20.backdend.repository.OrderItemRepository;
import com.webpet_nhom20.backdend.repository.OrderRepository;
import com.webpet_nhom20.backdend.repository.ProductVariantRepository;
import com.webpet_nhom20.backdend.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Override
    public OrderResponse createOrder(OrderRequest request, String token) {
        float itemsTotal = 0;
        Integer userIdFromToken = jwtTokenProvider.getUserId(token);

        // Tính tổng tiền từ product_variant.price
        for (OrderItemRequest itemReq : request.getItems()) {

            ProductVariants variant = productVariantRepository.findById(itemReq.getProductVariantId())
                    .orElseThrow(() -> new RuntimeException("Product variant not found"));

            double totalItemPrice = variant.getPrice() * itemReq.getQuantity();
            itemsTotal += totalItemPrice;
        }
        // Tính phần trăm giảm giá
        double discountPercent = request.getDiscountPercent() == null
                ? 0
                : request.getDiscountPercent();

        double discountValue = itemsTotal * (discountPercent / 100);
        // 1. Tính tổng tiền đơn hàng
        double totalAmount = itemsTotal
                + request.getShippingAmount()
                - discountValue;

        // 2. Tạo mã đơn hàng
        String orderCode = "ORD-" + System.currentTimeMillis();


        Order order = new Order();
        order.setUserId(userIdFromToken);
        order.setOrderCode(orderCode);
        order.setTotalAmount((float) totalAmount);
        order.setShippingAmount((float)request.getShippingAmount());
        order.setDiscountPercent(request.getDiscountPercent());
        order.setPaymentMethods(request.getPaymentMethods().name());
        order.setStatus(OrderStatus.PENDING.name());
        order.setShippingAddress(request.getShippingAddress());
        order.setIsDeleted("0");
        order.setNote(request.getNote());
        Order savedOrder = orderRepository.save(order);

        // 4. Lưu danh sách order items
        List<OrderItems> savedItems = new ArrayList<>();

        for (OrderItemRequest itemReq : request.getItems()) {

            ProductVariants variant = productVariantRepository.findById(itemReq.getProductVariantId())
                    .orElseThrow(() -> new RuntimeException("Product variant not found"));

            OrderItems item = new OrderItems();
            item.setOrderId(savedOrder.getId());
            item.setProductVariantId(itemReq.getProductVariantId());
            item.setQuantity(itemReq.getQuantity());
            item.setUnitPrice(variant.getPrice());
            item.setTotalPrice(variant.getPrice() * itemReq.getQuantity());
            item.setIsDeleted("0");
            savedItems.add(orderItemRepository.save(item));
        }

        OrderResponse response = new OrderResponse();
        response.setId(savedOrder.getId());
        response.setOrderCode(savedOrder.getOrderCode());
        response.setUserId(savedOrder.getUserId());
        response.setTotalAmount(savedOrder.getTotalAmount());
        response.setShippingAmount(savedOrder.getShippingAmount());
        response.setDiscountPercent(savedOrder.getDiscountPercent());
        response.setPaymentMethods(savedOrder.getPaymentMethods());
        response.setStatus(savedOrder.getStatus());
        response.setShippingAddress(savedOrder.getShippingAddress());
        response.setNote(savedOrder.getNote());
        response.setIsDeleted(savedOrder.getIsDeleted());
        response.setCreatedDate(savedOrder.getCreatedDate());
        response.setUpdatedDate(savedOrder.getUpdatedDate());
        // chuyển items về response
        List<OrderItemResponse> itemResponses = savedItems.stream().map(item -> {
            OrderItemResponse i = new OrderItemResponse();
            i.setOrderId(item.getOrderId());
            i.setProductVariantId(item.getProductVariantId());
            i.setQuantity(item.getQuantity());
            i.setUnitPrice(item.getUnitPrice());
            i.setTotalPrice(item.getTotalPrice());
            i.setIsDeleted(item.getIsDeleted());
            i.setCreatedDate(item.getCreatedDate());
            i.setUpdatedDate(item.getUpdatedDate());
            return i;
        }).toList();

        response.setItems(itemResponses);

        return response;
    }
}
