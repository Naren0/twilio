package com.naren.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naren.configuration.TwilioConfiguration;
import com.naren.request.SmsRequest;
import com.naren.request.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsSender implements SmsSender {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
	
	private final TwilioConfiguration twilioConfiguration;
	
	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}
	
	

	@Override
	public void sendSms(SmsRequest smsReqeust) {
		if(isPhoneNumerValid(smsReqeust.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(smsReqeust.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
			String message = smsReqeust.getMessage();
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();
			LOGGER.info("Message Sent to "+ smsReqeust);
		} else {
			
			throw new IllegalArgumentException("Phone number [ "+ smsReqeust.getPhoneNumber() +" ] is not a valid number" );
		}
		
	}
	
	
	private boolean isPhoneNumerValid(String phoneNumber) {
		return true;
	}
	
	

}
