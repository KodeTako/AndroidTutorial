package com.kodetako.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity implements OnClickListener {
	
	public static final String RESPONSE_KEY = "response";
	
	private EditText mResponseMessage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		String message = (String) getIntent().getExtras().get(MainActivity.MESSAGE_KEY);
		TextView tv = (TextView) findViewById(R.id.result_text);
		tv.setText(message);

		mResponseMessage = (EditText) findViewById(R.id.response_message);
		
		findViewById(R.id.cancel_button).setOnClickListener(this);
		findViewById(R.id.response_button).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cancel_button:
			setResult(Activity.RESULT_CANCELED);
			finish();
			break;
		case R.id.response_button:
			Intent response = getIntent();
			response.putExtra(RESPONSE_KEY, mResponseMessage.getText().toString());
			setResult(Activity.RESULT_OK, response);
			finish();
			break;

		default:
			break;
		}
		
	}
}
