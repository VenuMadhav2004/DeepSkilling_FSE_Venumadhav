package com.adaptor;

public class Main {
	 public static void main(String[] args) {
	        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
	        paypalProcessor.processPayment(100.0);

	        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
	        stripeProcessor.processPayment(250.0);
	    }
}
