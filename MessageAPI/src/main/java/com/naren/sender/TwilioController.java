package com.naren.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naren.request.SmsRequest;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {
	
	private final TwilioService twilioService;
	
	@Autowired
	public TwilioController(TwilioService twilioService) {
		this.twilioService = twilioService;
	}
	
	
	@PostMapping
	public void sendSms(@RequestBody SmsRequest smsRequest) {
		twilioService.sendSms(smsRequest);
	}

}
