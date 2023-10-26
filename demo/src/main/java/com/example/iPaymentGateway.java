package com.example;

// Интерфейс PaymentGateway, который наш класс зависит от него
public interface iPaymentGateway {
	boolean processPayment(double amount);
}