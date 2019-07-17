package com.alanlapierre.javatest.payment;

public class PaymentResponse {

	enum PaymentStatus {
		OK,ERROR
	}
	
	private PaymentStatus status;

	public PaymentResponse(PaymentStatus status) {
		super();
		this.status = status;
	}

	public PaymentStatus getStatus() {
		return status;
	}
	
	
}
