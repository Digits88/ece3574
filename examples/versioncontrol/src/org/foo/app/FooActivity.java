package org.foo.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FooActivity extends Activity {
	
	
	private static final String TAG = Activity.class.getName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.v(TAG, "A minor change.");
    }
}