package com.naren.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naren.request.SmsRequest;
import com.naren.request.SmsSender;

@Service
public class TwilioService {
	
	private final SmsSender smsSender;
	
	@Autowired
	public TwilioService (TwilioSmsSender twilioSmsSender) {
		this.smsSender = twilioSmsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}

}
