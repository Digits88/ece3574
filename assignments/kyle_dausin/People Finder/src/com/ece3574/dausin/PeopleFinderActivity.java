package com.ece3574.dausin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class PeopleFinderActivity extends Activity {
    /** Called when the activity is first created. */
	
	private HashMap<String, String> ParsedXML;
	private ImageView profilePhoto, addFriendPhoto;
    private ArrayList<Friend> appFriends = new ArrayList<Friend>();
    private LinearLayout friendsLayout_, addFriendLayout_;
    
    private static final int SHORT_PRESS_ALERT = 1;
    private static final int LONG_PRESS_ALERT = 2;
    private static final int FRIEND_PRESS_ALERT = 3;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);
		
		friendsLayout_ = (LinearLayout) findViewById(R.id.friendsLayout);
        
		addFriendPhoto = (ImageView) findViewById(R.id.addFriendPicture);
	    addFriendPhoto.setAdjustViewBounds(true);
	    addFriendPhoto.setMaxHeight(50);
	    addFriendPhoto.setMaxWidth(50);
	    
	    profilePhoto = (ImageView) findViewById(R.id.profilePicture);
	    profilePhoto.setAdjustViewBounds(true);
	    profilePhoto.setMaxHeight(50);
	    profilePhoto.setMaxWidth(50);
	    
	    addFriendLayout_ = (LinearLayout) findViewById(R.id.addFriendLayout);
	    addFriendLayout_.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//makeToast("Add Friend Layout Pressed.");
				makeDialog(FRIEND_PRESS_ALERT, "");
			}
	    	
	    });
	   
	    
	    tempFillContainer();
        
    }
    
    public void tempFillContainer() {
    	friendsLayout_.removeAllViews();
    	for(int i=0; i<10; i++) {
    		LinearLayout appFriendLayout_ = new LinearLayout(getBaseContext());
    		appFriendLayout_.setOrientation(1);
			String name = "Test Name " + Integer.toString(i+1);
    		LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	    hlp.setMargins(0, 0, 10, 0);
    	    ImageView photo = new ImageView(getBaseContext());
    	    photo.setImageResource(R.drawable.default_photo);
    	    photo.setLayoutParams(hlp);
    	    appFriendLayout_.addView(photo);
			TextView t = new TextView(getBaseContext());
			t.setText(name);
			t.setTextColor(0xFF800000);
			t.setTextSize(18);
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			llp.setMargins(0, 0, 0, 0);
			t.setLayoutParams(llp);
			appFriendLayout_.addView(t);
			LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			plp.setMargins(10, 10, 10, 10);
			appFriendLayout_.setLayoutParams(plp);
			appFriendLayout_.setTag(name);
			friendsLayout_.addView(appFriendLayout_);
			appFriendLayout_.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String tag = v.getTag().toString();
					//makeToast(tag + " pressed.");
					makeDialog(SHORT_PRESS_ALERT, tag);
				}
				
			});
			appFriendLayout_.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View arg0) {
					Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
					// Vibrate for 300 milliseconds
					v.vibrate(50);
					String tag = arg0.getTag().toString();
					//makeToast(tag + " long pressed.");
					makeDialog(LONG_PRESS_ALERT, tag);
					return true;
				}
				
			});
    	}
    }
    
	public void parseAppFriends() {
		for(int i=0; i<appFriends.size(); i++) {
			LinearLayout appFriendLayout_ = new LinearLayout(getBaseContext());
    	    URL img_value = null;
    	    try {
				img_value = new URL("http://graph.facebook.com/"+appFriends.get(i).id+"/picture?type=square");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    Bitmap mIcon1 = null;
			try {
				mIcon1 = BitmapFactory.decodeStream(img_value.openConnection().getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	    hlp.setMargins(0, 0, 10, 0);
    	    ImageView photo = new ImageView(getBaseContext());
    	    photo.setImageBitmap(mIcon1);
    	    photo.setLayoutParams(hlp);
    	    appFriendLayout_.addView(photo);
			TextView t = new TextView(getBaseContext());
			if(!ParsedXML.get(appFriends.get(i).id).equals("")){
				t.setText(appFriends.get(i).name + " - " + ParsedXML.get(appFriends.get(i).id));
			}
			else {
				t.setText(appFriends.get(i).name);
			}
			t.setTextColor(Globals.textColor);
			t.setTextSize(18);
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			llp.setMargins(0, 0, 0, 0);
			t.setLayoutParams(llp);
			appFriendLayout_.addView(t);
			LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			plp.setMargins(0, 10, 0, 10);
			appFriendLayout_.setLayoutParams(plp);
			friendsLayout_.addView(appFriendLayout_);
		}
	}
	
	public void makeToast(String str) {
		Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
	}
	
	public void makeDialog(int type, String tag) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		AlertDialog dialog;
		
		
		switch(type){
		case SHORT_PRESS_ALERT:
			builder.setMessage("This is a dummy message for a short press.  Name = " + tag);
			builder.setPositiveButton("Sweet", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
					//Do Something Here.
					
				}
				
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
					//Do something else here.
					
				}
				
			});
			
			dialog = builder.create();
			dialog.show();
			break;
		case LONG_PRESS_ALERT:
			builder.setMessage("This is a dummy message for a long press.  Name = " + tag);
			builder.setPositiveButton("Sweet", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
					//Do Something Here.
					
				}
				
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					dialog.cancel();
					//Do something else here.
					
				}
				
			});
			
			dialog = builder.create();
			dialog.show();
			break;
			
		case FRIEND_PRESS_ALERT:
			builder.setMessage("This is a dummy message for an add friend press.");
			builder.setPositiveButton("Sweet", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
					//Do Something Here.
					
				}
				
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					dialog.cancel();
					//Do something else here.
					
				}
				
			});
			
			dialog = builder.create();
			dialog.show();
			break;
		}
	}
	
}