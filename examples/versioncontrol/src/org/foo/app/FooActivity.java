package org.foo.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FooActivity extends Activity {
	
	// This is a comment made by Jacob Llaneras
	
	private static final String GAT = Activity.class.getName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.v(GAT, "A minor change.");
        Log.v(TAG, "Another minor change.");
    }
    
    public static final double PI = 3.1415926535897932384626433;
}