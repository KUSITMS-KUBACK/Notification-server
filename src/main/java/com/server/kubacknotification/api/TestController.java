package com.server.kubacknotification.api;

import com.server.kubacknotification.application.service.TestService;
import com.server.kubacknotification.global.common.PaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final TestService testService;

	@PostMapping("/payments")
	public ResponseEntity<String> sendPaymentMessage(@RequestBody PaymentMessage paymentMessage) {
		testService.publishPaymentMessage(paymentMessage);
		return ResponseEntity.ok("Payment message sent successfully");
	}
}
