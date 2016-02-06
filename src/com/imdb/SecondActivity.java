package com.imdb;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class SecondActivity extends MainActivity {
    ListView lv;
    Context context;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		context = this;
		Cursor cr = db.rawQuery("SELECT * FROM mov", null);
		Cursor cr2 = db.rawQuery("SELECT * FROM mov", null);
		Cursor cr3 = db.rawQuery("SELECT * FROM mov", null);
		
		String[] movName = new String[cr.getCount()];
		int i = 0;
		
		while(cr.moveToNext()){
		    String uname = cr.getString(cr.getColumnIndex("name"));
		    movName[i] = uname;
		    i++;
		}
		
		String[] movDescp = new String[cr2.getCount()];
		int j = 0;
		
		while(cr2.moveToNext()){
		    String desp = cr2.getString(cr2.getColumnIndex("description"));
		    movDescp[j] = desp;
		    j++;
		}
		
		Float [] movRate = new Float[cr3.getCount()];
		int k = 0;
		while(cr3.moveToNext()){
			float rate = cr3.getFloat(cr3.getColumnIndex("rating"));
			movRate[k] = rate;
			k++;
		}
		
		
		lv= (ListView)findViewById(R.id.listView1);
		lv.setAdapter(new CustomAdapter(this, movName, movDescp,movRate));

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
}
