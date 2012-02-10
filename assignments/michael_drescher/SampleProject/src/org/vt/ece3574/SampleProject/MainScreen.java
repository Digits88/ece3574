package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.LinearLayout;

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
	
	public void swapLayout(View v){
		LinearLayout l = (LinearLayout) v.getParent();
		int count = l.getChildCount();
		View[] views = new View[count];
		for(int i = 0; i < count; i++){
			views[i] = l.getChildAt(i);
		}
		l.removeAllViews();
		for(int i = 0; i < count; i++){
			l.addView(views[(i + 1)%count]);
		}
	}
    
}