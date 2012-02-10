package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;

public class AboutScreen extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

	public void goToMainScreen(View arg0) {
		this.finish();
	}

}
