package com.kodetako.androidtutorial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		String message = (String) getIntent().getExtras().get(MainActivity.MESSAGE_KEY);
		TextView tv = (TextView) findViewById(R.id.result_text);
		tv.setText(message);
		
		Button finishButton = (Button) findViewById(R.id.finish_button);
		finishButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
