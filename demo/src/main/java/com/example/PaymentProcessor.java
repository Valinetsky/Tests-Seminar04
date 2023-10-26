package com.example;

// Класс PaymentProcessor, который мы будем тестировать
public class PaymentProcessor {
	private iPaymentGateway gateway;

	public PaymentProcessor(iPaymentGateway gateway) {
		this.gateway = gateway;
	}

	public boolean makePayment(double amount) {
		return gateway.processPayment(amount);
	}
}