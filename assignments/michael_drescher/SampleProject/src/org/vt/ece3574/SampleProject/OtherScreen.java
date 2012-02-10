package org.vt.ece3574.SampleProject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class OtherScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
	}

	public void goToMainScreen(View arg0) {
		this.finish();
	}

}
