package com.kodetako.androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	private static final String TAG = "MainActivity";
	public static final String MESSAGE_KEY = "message";
	
	private EditText	mTextToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTextToSend = (EditText) findViewById(R.id.text_to_send);
        
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendTextToNextActivity();
			}
		});
    }
    
    private void sendTextToNextActivity () {
    	Intent i = new Intent(this, SecondActivity.class);
    	i.putExtra(MESSAGE_KEY, mTextToSend.getText().toString());
    	startActivity(i);
    }
}
