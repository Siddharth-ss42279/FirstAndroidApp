package com.imdb;

import java.util.zip.Inflater;



import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomAdapter implements ListAdapter {

	
	String [] name;
	String [] desc;
	Context context;
	Float [] rt;
	
	private static LayoutInflater inflater=null;
	/*public CustomAdapter(SecondActivity secondActivity, String[] movName, String[] movDescp,Float[]movRate) {
		// TODO Auto-generated constructor stub
		name = movName;
		desc = movDescp;
		context = secondActivity;
	    inflater = (LayoutInflater)context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
*/

	public CustomAdapter(SecondActivity secondActivity, String[] movName, String[] movDescp, Float[] movRate) {
		// TODO Auto-generated constructor stub
		name = movName;
		desc = movDescp;
		context = secondActivity;
		rt = movRate;
	    inflater = (LayoutInflater)context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	public class Holder
    {
        TextView tv;
        TextView tv1;
        RatingBar r;
    }
	static int l= 0;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		 Holder holder = new Holder();
		 View rowView;       
             rowView = inflater.inflate(R.layout.program_list, null);
             holder.tv=(TextView) rowView.findViewById(R.id.textView1);
             holder.tv1=(TextView) rowView.findViewById(R.id.textView2);
             holder.r = (RatingBar)rowView.findViewById(R.id.ratingBar1);
             holder.tv.setText(name[position]);
             holder.tv1.setText(desc[position]);
             holder.r.setRating(rt[position]);
             
             return rowView;
	}


	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return false;
	}
}

