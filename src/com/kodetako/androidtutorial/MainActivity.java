package com.kodetako.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static final String TAG = "MainActivity";
	public static final String MESSAGE_KEY = "message";
	private static final int REQUEST_CODE_SEND_MESSAGE = 1;

	private EditText 	mTextToSend;
	private TextView	mResultText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextToSend = (EditText) findViewById(R.id.text_to_send);
		mResultText = (TextView) findViewById(R.id.result_text);

		Button nextButton = (Button) findViewById(R.id.nextButton);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendTextToNextActivity();
			}
		});
	}

	private void sendTextToNextActivity() {
		Intent i = new Intent(this, SecondActivity.class);
		i.putExtra(MESSAGE_KEY, mTextToSend.getText().toString());
		startActivityForResult(i, REQUEST_CODE_SEND_MESSAGE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		switch (requestCode) {
		case REQUEST_CODE_SEND_MESSAGE:
			onSendMessageResult(resultCode, intent);
			break;
		default:
			break;
		}
	}

	private void onSendMessageResult(int resultCode, Intent intent) {
		switch (resultCode) {
		case Activity.RESULT_OK:
			String result = intent.getExtras().getString(SecondActivity.RESPONSE_KEY);
			mResultText.setText(result);
			break;
		case Activity.RESULT_CANCELED:
			Toast.makeText(MainActivity.this, R.string.toast_result_canceled, Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
