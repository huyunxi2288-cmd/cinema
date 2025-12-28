package com.cinema.service;

import com.cinema.dao.PaymentDao;
import com.cinema.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    // 获取所有支付记录
    public List<Payment> getPayments(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return paymentDao.getPayments(offset, pageSize);
    }

    // 获取单个支付记录
    public Payment getPaymentById(String paymentId) {
        return paymentDao.getPaymentById(paymentId);
    }

    // 创建支付记录
    public void addPayment(String paymentId, String orderId, double paymentAmount, String paymentMethod, String paymentTime) {
        paymentDao.addPayment(paymentId, orderId, paymentAmount, paymentMethod, paymentTime);
    }

    // 更新支付状态
    public void updatePaymentStatus(String paymentId, String paymentStatus) {
        paymentDao.updatePaymentStatus(paymentId, paymentStatus);
    }
}
