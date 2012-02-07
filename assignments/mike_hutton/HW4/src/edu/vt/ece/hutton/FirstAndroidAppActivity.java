package edu.vt.ece.hutton;

import android.app.Activity;
import android.os.Bundle;
import android.opengl.GLSurfaceView;
import android.content.Context;

public class FirstAndroidAppActivity extends Activity {
    /** Called when the activity is first created. */
	
	private MySurfaceView GLView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main); //set view to xml-based GUI
        
        GLView = new MySurfaceView(this);
        setContentView(GLView);
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	GLView.onPause();
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	GLView.onResume();
    }
}

class MySurfaceView extends GLSurfaceView {
	
	public MySurfaceView(Context context) {
		super(context);
		
		setRenderer(new MySurfaceRenderer());
	}
	
}