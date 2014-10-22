package com.huluwa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TianZhenActivity extends Activity {
	static String phoneNumber=null;
	static EditText forbiddenNumber;
	static EditText forbiddenNumber1;
	static EditText forbiddenContent;
	Button forbiddenButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        forbiddenNumber=(EditText)findViewById(R.id.forbiddenNumber);
        forbiddenNumber1=(EditText)findViewById(R.id.forbiddenNumber1);
        forbiddenContent=(EditText)findViewById(R.id.forbiddenContent);
        forbiddenButton=(Button)findViewById(R.id.forbiddenButton);
        forbiddenButton.setOnClickListener(new ButtonClickListener());
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
        	forbiddenNumber1.setText(bundle.getString("number"));
        	forbiddenContent.setText(bundle.getString("content"));
        }
       
    }
}

class ButtonClickListener implements OnClickListener{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.forbiddenButton:
			TianZhenActivity.phoneNumber=TianZhenActivity.forbiddenNumber.getText().toString();
			break;
		}
	}
	
}