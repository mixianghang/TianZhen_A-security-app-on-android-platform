package com.huluwa;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsFilter extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
        // 第一步、获取短信的内容和发件人  
        StringBuilder body = new StringBuilder();// 短信内容  
        StringBuilder number = new StringBuilder();// 短信发件人  
        Bundle bundle = intent.getExtras();  
        if (bundle != null) {  
            Object[] _pdus = (Object[]) bundle.get("pdus");  
            SmsMessage[] message = new SmsMessage[_pdus.length];  
            for (int i = 0; i < _pdus.length; i++) {  
                message[i] = SmsMessage.createFromPdu((byte[]) _pdus[i]);  
            }  
            for (SmsMessage currentMessage : message) {  
                body.append(currentMessage.getDisplayMessageBody());  
                number.append(currentMessage.getDisplayOriginatingAddress());  
            }  
            String smsBody = body.toString();  
            String smsNumber = number.toString();  
            if (smsNumber.contains("+86")) {  
                smsNumber = smsNumber.substring(3);  
            }  
            if(smsNumber.equals(TianZhenActivity.phoneNumber)){
            	TianZhenActivity.forbiddenNumber1.setText(smsNumber);
            	TianZhenActivity.forbiddenContent.setText(smsBody);
            	Intent i=new Intent(context,TianZhenActivity.class);
            	i.putExtra("number", smsNumber);
                i.putExtra("content", smsBody);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.abortBroadcast();
                context.startActivity(i);
            }
        }
	}

}
