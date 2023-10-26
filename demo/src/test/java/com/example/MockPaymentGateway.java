package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

// Мок, имитирует PaymentGateway и записывает вызовы методов
public class MockPaymentGateway {
	// private boolean lastPaymentStatus;

	@Test
	public void testMakePaymentWithSuccessfulPayment() {

		// Создаем мок-объект
		iPaymentGateway mockGateway = mock(iPaymentGateway.class);

		// Устанавливаем, что он должен вернуть true про вызове processPayment
		when(mockGateway.processPayment(anyDouble())).thenReturn(true);

		PaymentProcessor processor = new PaymentProcessor(mockGateway);

		// Вызываем метод makePayment
		boolean result = processor.makePayment(100.0);

		// Проверяем, что метод processPayment был вызван один раз
		verify(mockGateway, times(1)).processPayment(anyDouble());

		// Проверяем результат
		assertTrue(result);
	}
}