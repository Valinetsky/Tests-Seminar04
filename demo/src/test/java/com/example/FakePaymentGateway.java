package com.example;

import java.util.ArrayList;
import java.util.List;

// Подделка, заменяет функциональность PaymentGateway
public class FakePaymentGateway implements iPaymentGateway {
	private List<Double> paymentHistory = new ArrayList<>();

	@Override
	public boolean processPayment(double amount) {
		// Здесь мы можем реализовать альтернативную функциональность
		// Например, всегда успешное выполнение, но с другими действиями
		// Это зависит от того, какой функциональности вам нужно подделать
		// В данном случае, мы всегда возвращаем успешное выполнение платежа
		paymentHistory.add(amount);
		return true;
	}

	public List<Double> getPaymentHistory() {
		return paymentHistory;
	}
}