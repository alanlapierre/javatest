package com.alanlapierre.javatest.payment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentProcessorTest {

	private PaymentGateway paymentGateway;
	private PaymentProcessor paymentProcessor;
	
	@Before
	public void setup() {
		paymentGateway = Mockito.mock(PaymentGateway.class);
		paymentProcessor = new PaymentProcessor(paymentGateway);
	}

	
	@Test
	public void payment_is_correct() {
		
		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		
		assertTrue(paymentProcessor.makePayment(1000D));
	}

	@Test
	public void payment_is_incorrect() {

		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
				.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

		assertFalse(paymentProcessor.makePayment(1000D));
	}

}
