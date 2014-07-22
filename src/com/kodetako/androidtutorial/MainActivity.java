package com.kodetako.androidtutorial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final TextView tv = (TextView) findViewById(R.id.bind_tv_example);
        
        EditText et = (EditText) findViewById(R.id.bind_et_example);
        et.addTextChangedListener(new TextWatcher() {
			
			@Override public void onTextChanged(CharSequence s, int start, int before, int count) { }
			
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
			
			@Override
			public void afterTextChanged(Editable s) {
				tv.setText(s);
			}
		});
    }
}
