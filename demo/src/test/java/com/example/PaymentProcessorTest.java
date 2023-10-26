package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PaymentProcessorTest {

	@Test
	void testDummyPaymentProcessor() {
		iPaymentGateway dummyGateway = new DummyPaymentGateway();

		PaymentProcessor processor = new PaymentProcessor(dummyGateway);
		// Теперь можно тестировать PaymentProcessor с использованием
		// DummyPaymentGateway

		boolean result = processor.makePayment(1000.0);

		assertTrue(result);
	}

	@Test
	void testStubPaymentProcessor() {
		iPaymentGateway stubGateway = new StubPaymentGateway();

		PaymentProcessor processor = new PaymentProcessor(stubGateway);
		// Теперь можно тестировать PaymentProcessor с использованием
		// StubPaymentGateway

		boolean result = processor.makePayment(1000.0);

		assertTrue(result);
	}

	@Test
	void testSpyPaymentProcessor() {
		iPaymentGateway spyGateway = new SpyPaymentGateway();

		PaymentProcessor processor = new PaymentProcessor(spyGateway);
		// Теперь можно тестировать PaymentProcessor с использованием
		// SpyPaymentGateway

		boolean result = processor.makePayment(100.0);

		// Проверяем, что метод был вызван
		assertEquals(1, ((SpyPaymentGateway) spyGateway).getPaymentCount());

		// Проверяем результат
		assertTrue(result);
	}

	@Test
	void testFakePaymentProcessor() {
		iPaymentGateway fakeGateway = new FakePaymentGateway();

		PaymentProcessor processor = new PaymentProcessor(fakeGateway);
		// Теперь можно тестировать PaymentProcessor с использованием
		// FakePaymentGateway

		// Вызываем метод с разными суммами
		processor.makePayment(100.0);
		processor.makePayment(50.0);
		processor.makePayment(200.0);

		// Получаем историю платежей
		List<Double> paymentHistory = ((FakePaymentGateway) fakeGateway).getPaymentHistory();

		// Проверяем, что метод был вызван
		assertEquals(3, paymentHistory.size());
		assertEquals(100.0, paymentHistory.get(0));
		assertEquals(50.0, paymentHistory.get(1));
		assertEquals(200.0, paymentHistory.get(2));

	}
}
