package com.example;

// Шпион, записывает информацию о вызовах методов
public class SpyPaymentGateway implements iPaymentGateway {
	private int paymentCount = 0;

	@Override
	public boolean processPayment(double amount) {
		paymentCount++;
		// Реальная логика обработки платежа (может быть пустой, так как это пример)
		return true;
	}

	// Дополнительный метод для проверки количества вызовов
	public int getPaymentCount() {
		return paymentCount;
	}
}