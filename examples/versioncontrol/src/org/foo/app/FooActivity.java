package org.foo.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FooActivity extends Activity {
	
	// This is a comment made by Jacob Llaneras
	// Maybe, maybe not
	private static final String TAG = Activity.class.getName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        Log.v(TAG, "Some random minor change.");

        Log.v(TAG, "Another minor change.");
        
        Log.v(TAG, "Foo");
    }
    
    public static final double PI = 3.1415926535897932384626433;
}

/* I dont understand Java */