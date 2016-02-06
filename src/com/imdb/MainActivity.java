package com.imdb;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText mvName,mvDescp;
	RatingBar rtBar;
	Button btnAdd, btnShow;
    SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mvName = (EditText)findViewById(R.id.editText1);
		mvDescp = (EditText)findViewById(R.id.editText2);
		rtBar = (RatingBar)findViewById(R.id.ratingBar1);
		btnAdd = (Button)findViewById(R.id.button1);
		btnShow = (Button)findViewById(R.id.button2);
		
		db=openOrCreateDatabase("Movdb", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS mov(name VARCHAR, description VARCHAR, rating float);");
	}
	
	public void ADD(View view)
	{
		if(view == btnAdd)
		{
			if(mvName.getText().toString().length() == 0 || rtBar.getRating() == 0)
			{	
				Toast.makeText(getBaseContext(), "fields empty", Toast.LENGTH_SHORT).show();
			    return;
			} 
			db.execSQL("INSERT INTO mov VALUES('"+mvName.getText()+"','"+mvDescp.getText()+"','"+rtBar.getRating()+"');");
			Toast.makeText(getBaseContext(), "succesfully added", Toast.LENGTH_SHORT).show();
			clearText();
		}
	}
	
	

	private void clearText() {
		// TODO Auto-generated method stub
		mvName.setText("");
		mvDescp.setText("");
		mvName.requestFocus();
		
	}
	public void SHOW(View v)
	{
		Intent i= new Intent(MainActivity.this,SecondActivity.class);
		startActivity(i);
		//overridePendingTransition(R.anim.push_left_in, R.anim.push_up_out);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
