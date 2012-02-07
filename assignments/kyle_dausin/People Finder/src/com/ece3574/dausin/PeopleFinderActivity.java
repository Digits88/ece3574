package com.ece3574.dausin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class PeopleFinderActivity extends Activity {
    /** Called when the activity is first created. */
	
	private HashMap<String, String> ParsedXML;
	private ImageView profilePhoto, addFriendPhoto;
    private ArrayList<Friend> appFriends = new ArrayList<Friend>();
    private LinearLayout friendsLayout_;
    HorizontalScrollView friendsContainer_;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		//friendsRelativeLayout_ = (RelativeLayout) findViewById(R.id.FriendsRelativeLayout);
		
		friendsLayout_ = (LinearLayout) findViewById(R.id.friendsLayout);
        
		addFriendPhoto = (ImageView) findViewById(R.id.addFriendPicture);
	    addFriendPhoto.setAdjustViewBounds(true);
	    addFriendPhoto.setMaxHeight(50);
	    addFriendPhoto.setMaxWidth(50);
	    
	    profilePhoto = (ImageView) findViewById(R.id.profilePicture);
	    profilePhoto.setAdjustViewBounds(true);
	    profilePhoto.setMaxHeight(50);
	    profilePhoto.setMaxWidth(50);
	    
	    friendsContainer_ = (HorizontalScrollView) findViewById(R.id.friendsContainer);
	   
	    
	    tempFillContainer();
	    
	    //friendsContainer_.addView(friendsLayout_);
        
    }
    
    public void tempFillContainer() {
    	friendsLayout_.removeAllViews();
    	for(int i=0; i<10; i++) {
    		LinearLayout appFriendLayout_ = new LinearLayout(getBaseContext());
    		appFriendLayout_.setOrientation(1);
    		LinearLayout.LayoutParams hlp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	    hlp.setMargins(0, 0, 10, 0);
    	    ImageView photo = new ImageView(getBaseContext());
    	    photo.setImageResource(R.drawable.default_photo);
    	    photo.setLayoutParams(hlp);
    	    appFriendLayout_.addView(photo);
			TextView t = new TextView(getBaseContext());
			t.setText("Test Name");
			t.setTextColor(0xFF800000);
			t.setTextSize(18);
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			llp.setMargins(0, 0, 0, 0);
			t.setLayoutParams(llp);
			appFriendLayout_.addView(t);
			LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			plp.setMargins(10, 10, 10, 10);
			appFriendLayout_.setLayoutParams(plp);
			friendsLayout_.addView(appFriendLayout_);
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
}