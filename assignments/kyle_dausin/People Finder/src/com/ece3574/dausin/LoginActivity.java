package com.ece3574.dausin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    
    private EditText source1;
    private EditText source2;
	private Button someButton;
	private TextView top;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        top = (TextView) findViewById(R.id.textbox2);
        top.setText("Name:");
        
        TextView myText2 = (TextView) findViewById(R.id.textbox);
        myText2.setText("Password:");
        
        source1 = (EditText)findViewById(R.id.stringfield1);
        source2 = (EditText)findViewById(R.id.stringfield2);
        someButton = (Button)findViewById(R.id.loginButton);
        
        someButton.setOnClickListener(this);    
    }

	@Override
	public void onClick(View arg0) {
		String user = source1.getText().toString();
		String password = source2.getText().toString();
		if(password.equals("123") && user.equals("Bob")){
			user = "correct!";
			top.setText(user);
        	Intent i = new Intent(LoginActivity.this, PeopleFinderActivity.class);
        	startActivity(i);
		}	else{
			user = "bad password";
			top.setText(user);
		}
	}

}