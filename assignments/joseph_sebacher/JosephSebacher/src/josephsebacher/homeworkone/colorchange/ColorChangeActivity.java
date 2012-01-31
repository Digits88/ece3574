package josephsebacher.homeworkone.colorchange;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class ColorChangeActivity extends Activity {

	private EditText mTextBox;
	private Button mTopButton;
	private Button mMiddleButton;
	private Button mBottomButton;
	private TextView mTopColorBox;
	private TextView mMiddleColorBox;
	private TextView mBottomColorBox;
	
	private String string;
	
    public void onCreate(Bundle savedInstanceState)
    	{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            
            mTextBox = (EditText) findViewById(R.id.textbox);
            mTopButton = (Button) findViewById(R.id.topbutton);
            mMiddleButton = (Button) findViewById(R.id.middlebutton);
            mBottomButton = (Button) findViewById(R.id.bottombutton);
            mTopColorBox = (TextView) findViewById(R.id.topcolorbox);
            mMiddleColorBox = (TextView) findViewById(R.id.middlecolorbox);
            mBottomColorBox = (TextView) findViewById(R.id.bottomcolorbox);
            
            mTopButton.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View v) {
            		updateTopColor();
            	}
            });
            mMiddleButton.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View v) {
            		updateMiddleColor();
            	}
            });
            mBottomButton.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View v) {
            		updateBottomColor();
            	}
            });
        }
    
    public void updateTopColor()
    {
    	string = mTextBox.getText().toString().toLowerCase();
    	if(string.equals("black"))
    	{
    		mTopColorBox.setBackgroundColor(Color.BLACK);
    	}
    	else if(string.equals("blue"))
    	{
    		mTopColorBox.setBackgroundColor(Color.BLUE);
    	}
    	else if(string.equals("cyan"))
    	{
    		mTopColorBox.setBackgroundColor(Color.CYAN);
    	}
    	else if(string.equals("gray"))
    	{
    		mTopColorBox.setBackgroundColor(Color.GRAY);
    	}
    	else if(string.equals("green"))
    	{
    		mTopColorBox.setBackgroundColor(Color.GREEN);
    	}
    	else if(string.equals("magenta"))
    	{
    		mTopColorBox.setBackgroundColor(Color.MAGENTA);
    	}
    	else if(string.equals("red"))
    	{
    		mTopColorBox.setBackgroundColor(Color.RED);
    	}
    	else if(string.equals("white"))
    	{
    		mTopColorBox.setBackgroundColor(Color.WHITE);
    	}
    	else if(string.equals("yellow"))
    	{
    		mTopColorBox.setBackgroundColor(Color.YELLOW);
    	}
    	else
    	{
    		mTopColorBox.setBackgroundColor(Color.TRANSPARENT);
    	}
    }
    
    public void updateMiddleColor()
    {
    	string = mTextBox.getText().toString().toLowerCase();
    	if(string.equals("black"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.BLACK);
    	}
    	else if(string.equals("blue"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.BLUE);
    	}
    	else if(string.equals("cyan"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.CYAN);
    	}
    	else if(string.equals("gray"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.GRAY);
    	}
    	else if(string.equals("green"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.GREEN);
    	}
    	else if(string.equals("magenta"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.MAGENTA);
    	}
    	else if(string.equals("red"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.RED);
    	}
    	else if(string.equals("white"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.WHITE);
    	}
    	else if(string.equals("yellow"))
    	{
    		mMiddleColorBox.setBackgroundColor(Color.YELLOW);
    	}
    	else
    	{
    		mMiddleColorBox.setBackgroundColor(Color.TRANSPARENT);
    	}
    }
    
    public void updateBottomColor()
    {
    	string = mTextBox.getText().toString().toLowerCase();
    	if(string.equals("black"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.BLACK);
    	}
    	else if(string.equals("blue"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.BLUE);
    	}
    	else if(string.equals("cyan"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.CYAN);
    	}
    	else if(string.equals("gray"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.GRAY);
    	}
    	else if(string.equals("green"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.GREEN);
    	}
    	else if(string.equals("magenta"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.MAGENTA);
    	}
    	else if(string.equals("red"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.RED);
    	}
    	else if(string.equals("white"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.WHITE);
    	}
    	else if(string.equals("yellow"))
    	{
    		mBottomColorBox.setBackgroundColor(Color.YELLOW);
    	}
    	else
    	{
    		mBottomColorBox.setBackgroundColor(Color.TRANSPARENT);
    	}
    }
}