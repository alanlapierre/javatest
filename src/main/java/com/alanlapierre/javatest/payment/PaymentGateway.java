package com.alanlapierre.javatest.payment;

public interface PaymentGateway {

	PaymentResponse requestPayment(PaymentRequest request);
}
