package com.cinema.controller;

import com.cinema.dto.Payment;
import com.cinema.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 获取支付记录列表
    @GetMapping("/list")
    public List<Payment> getPayments(@RequestParam int pageNum, @RequestParam int pageSize) {
        return paymentService.getPayments(pageNum, pageSize);
    }

    // 获取单个支付记录
    @GetMapping("/{paymentId}")
    public Payment getPayment(@PathVariable String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    // 创建支付记录
    @PostMapping("/add")
    public String addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment.getPaymentId(), payment.getOrderId(),
                payment.getPaymentAmount(), payment.getPaymentMethod(), payment.getPaymentTime());
        return "Payment record created successfully";
    }

    // 更新支付状态
    @PutMapping("/update/{paymentId}")
    public String updatePaymentStatus(@PathVariable String paymentId, @RequestBody Payment payment) {
        paymentService.updatePaymentStatus(paymentId, payment.getPaymentStatus());
        return "Payment status updated successfully";
    }
}
