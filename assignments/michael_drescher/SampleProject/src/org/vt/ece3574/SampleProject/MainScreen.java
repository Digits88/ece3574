package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;

public class MainScreen extends Activity{
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	public void goToAboutScreen(View v) {
		v.playSoundEffect(SoundEffectConstants.CLICK);
		Intent intent = new Intent(this, AboutScreen.class);
		startActivity(intent);
		}
	
	public void goToOtherScreen(View v) {
		v.playSoundEffect(SoundEffectConstants.CLICK);
		Intent intent = new Intent(this, OtherScreen.class);
		startActivity(intent);
	}
    
}