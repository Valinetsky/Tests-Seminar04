package com.example;

public class DummyPaymentGateway implements iPaymentGateway {
	@Override
	public boolean processPayment(double amount) {
		// Не выполняем никаких действий, просто фиктивный объект return true;
		return true;
	}
}