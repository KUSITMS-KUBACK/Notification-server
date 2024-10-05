package com.server.kubacknotification.global.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMessage {
	private Long userId;
	private String email;
	private String userName;
	private String seatNumber;
	private String seatGrade;
	private String payment;
	private LocalDateTime payDate;
	private String originalPrice;
	private String salePrice;
	private String finalPrice;
}

