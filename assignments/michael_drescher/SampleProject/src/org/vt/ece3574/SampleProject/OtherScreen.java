package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;

public class OtherScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
	}

	public void goToMainScreen(View arg0) {
		arg0.playSoundEffect(SoundEffectConstants.CLICK);
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}

}
