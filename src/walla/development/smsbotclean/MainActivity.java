package walla.development.smsbotclean;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void sendenvorbereiten(View view){
		
		String msginString;
		String phonenumber;
		int times;
		String timesString;
		int i;
		TextView txtview= (TextView) findViewById(R.id.textView1);	
		EditText editText = (EditText) findViewById(R.id.message);
	    msginString =  editText.getText().toString();
	    EditText editText2 = (EditText) findViewById(R.id.phonenumber);
	    phonenumber =  editText2.getText().toString();
	    EditText editText3 = (EditText) findViewById(R.id.times);
	    timesString =  editText3.getText().toString();
	    times = Integer.parseInt(timesString);
//	    Intent intent = new Intent (Intent.ACTION_VIEW);
	    SmsManager manager = SmsManager.getDefault();
	    txtview.setText("Sending");
	    txtview.setVisibility(TextView.VISIBLE);
	    PendingIntent piSent = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent("SMS_SENT"), 0);
		PendingIntent piDelivered = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent("SMS_DELIVERED"), 0);
	    
	    for( i=0; i< times; i++){
	    	manager.sendTextMessage(phonenumber, null, msginString, piSent, piDelivered);
	    }
	   txtview.setText("Sent");
	}
	}


