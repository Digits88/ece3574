package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class AboutScreen extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        Button myButton = (Button)findViewById(R.id.button1);
        Animation buttonSpin = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        buttonSpin.setDuration(1000);
        buttonSpin.setRepeatCount(-1);
        Interpolator i = new LinearInterpolator();
        buttonSpin.setInterpolator(i);
        myButton.setAnimation(buttonSpin);
    }

	public void goToMainScreen(View arg0) {
		this.finish();
	}

}
