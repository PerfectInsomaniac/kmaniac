package com.example.kmaniac;


import android.content.Context;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
   private  int [][]obj = new int[5][5];
 
    // Keep all Images in array
    
   
    // Constructor
    public ImageAdapter(Context c,boardDisplay b){
        mContext = c;
        this.obj= b.board;
    }
 
  
    
    public Integer[] mThumbIds = {
    		
    		 		R.drawable.eight, R.drawable.eight, R.drawable.eight,R.drawable.eight,R.drawable.ns,
    		 		R.drawable.eight, R.drawable.eight, R.drawable.eight,R.drawable.eight,R.drawable.zero,
    	        		R.drawable.eight, R.drawable.eight, R.drawable.eight,R.drawable.eight,R.drawable.zero, 
    	        				R.drawable.eight, R.drawable.eight, R.drawable.eight,R.drawable.eight,R.drawable.zero, 
    	        				R.drawable.eight, R.drawable.eight, R.drawable.eight,R.drawable.eight,R.drawable.zero,
    };

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
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        
        
     
     imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
 
}