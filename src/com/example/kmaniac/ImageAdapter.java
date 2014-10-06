package com.example.kmaniac;


import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
   private  Integer [][]obj ;
  

    // Keep all Images in array
    
   
    // Constructor
    public ImageAdapter(Context c,boardDisplay abc){
        mContext = c;
        this.obj= abc.board;
       
        
    }
 
  
    
   


	public Integer[] mThumbIds = {
    		
    		 		R.drawable.zero, R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,
    		 		R.drawable.five, obj[1][1], obj[1][2],obj[1][3],obj[1][4],
    	        		R.drawable.six, obj[2][1], obj[2][2],obj[2][3],obj[2][4],
    	        				R.drawable.seven,  obj[3][1], obj[3][2],obj[3][3],obj[3][4],
    	        				R.drawable.eight,  obj[4][1], obj[4][2],obj[4][3],obj[4][4],
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