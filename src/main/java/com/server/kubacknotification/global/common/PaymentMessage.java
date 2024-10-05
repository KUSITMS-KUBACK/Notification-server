package com.server.kubacknotification.global.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "결제 메시지")
public class PaymentMessage {

	@Schema(description = "유저 ID", example = "1")
	private Long userId;

	@Schema(description = "유저 이메일", example = "@gmail.com")
	private String email;

	@Schema(description = "유저 이름", example = "문희상")
	private String userName;

	@Schema(description = "좌석 번호", example = "A12")
	private String seatNumber;

	@Schema(description = "좌석 등급", example = "VIP")
	private String seatGrade;

	@Schema(description = "결제 금액", example = "15000")
	private String payment;

	@Schema(description = "결제 날짜", example = "2024-10-06T14:00:00")
	private LocalDateTime payDate;

	@Schema(description = "원래 가격", example = "20000")
	private String originalPrice;

	@Schema(description = "할인 금액", example = "5000")
	private String salePrice;

	@Schema(description = "최종 결제 금액", example = "15000")
	private String finalPrice;
}



