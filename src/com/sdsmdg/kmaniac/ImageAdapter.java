package com.sdsmdg.kmaniac;

import android.content.Context;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sdsmdg.kmaniac.R;

public class ImageAdapter extends BaseAdapter {

	private Context mContext;
	private Integer[][] obj;
	public Integer[] mThumbIds= new Integer [25];
	// Keep all Images in array

	// Constructor
	public ImageAdapter(Context c, boardDisplay abc) {
		mContext = c;
		this.obj = abc.board;
		for(int i=0,j=0;i<5;i++)
		{
			for(int k=0;k<5;k++)
				mThumbIds[j++]=obj[i][k];
		}
	
		
				
	}
	public ImageAdapter(Context c, fourBoard abc) {
		mContext = c;
		this.obj = abc.board;
		for(int i=0,j=0;i<5;i++)
		{
			for(int k=0;k<5;k++)
				mThumbIds[j++]=obj[i][k];
		}
	
		
				
	}

	

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return mThumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = new ImageView(mContext);
		
		
		if(mThumbIds[position]==0)
	    {imageView.setImageResource(R.drawable.noimage);
	    imageView.setTag("NO_IMAGE");
	    }
		else
		{
			imageView.setImageResource(mThumbIds[position]);
	        if(position<6||position==10||position==15||position==20)
			imageView.setTag("NOT_TO_SELECT");
	        else
	        {
	        imageView.setTag("NOT_SELECTED");	
	        }
		}
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

		imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
		return imageView;
	}

}