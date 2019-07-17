package com.alanlapierre.javatest.payment;

public class PaymentProcessor {

	private PaymentGateway paymentGateway;
	
	public PaymentProcessor(PaymentGateway paymentGateway) {
		super();
		this.paymentGateway = paymentGateway;
	}

	public Boolean makePayment(Double amount){
		PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
		
		if(response.getStatus() == PaymentResponse.PaymentStatus.OK){
			return true;
		}
		return false;
	}
}
