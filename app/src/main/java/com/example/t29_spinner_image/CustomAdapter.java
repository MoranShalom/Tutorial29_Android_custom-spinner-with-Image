package com.example.t29_spinner_image;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter {

    //Inner class and name it ViewHolder, inside this class we will declare the views inside custom_spinner_row.xml
    private static class ViewHolder {
        ImageView mFlag;
        TextView mName;
        TextView mPopulation;
    }

    private String[] spinnerTitles;
    private String [] spinnerPopulation;
    private int[] spinnerImages;
    private Context mContext;



    public CustomAdapter(@NonNull Context context, String[] titles, int[] images, String[] population) {
        super(context, R.layout.custom_spinner_row);

        this.spinnerTitles= titles;
        this.spinnerPopulation= population;
        this.spinnerImages= images;
        this.mContext=context;

    }

    // getCount : Return the number of items in the list. If you don’t override this method, the spinner list will be empty.
    @Override
    public int getCount(){
        // Inside getCount method we will return the number of titles inside the spinner
        return spinnerTitles.length;
    }

    // getView : This is where we work with initializing the views that we added them in the custom layout
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        //initialize the views inside getView method
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView==null){
            // next will be inflate the custom_spinner_row layout file, so that we can have access to the views inside the file
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= mInflater.inflate(R.layout.custom_spinner_row, parent, false);

            mViewHolder.mFlag= (ImageView) convertView.findViewById(R.id.ivFlag);
            mViewHolder.mName= (TextView) convertView.findViewById(R.id.tvName);
            mViewHolder.mPopulation= (TextView) convertView.findViewById(R.id.tvPopulation);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder=(ViewHolder)convertView.getTag();
        }

        mViewHolder.mFlag.setImageResource(spinnerImages[position]);
        mViewHolder.mName.setText(spinnerTitles[position]);
        mViewHolder.mPopulation.setText(spinnerPopulation[position]);


        return convertView;

    }

    //getDropDownView: This will show the data when you tap on Android spinner,
    // if you don’t override this method your app will crash when you try to tap on the spinner.
   @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        //Inside getDropDownView method we will return getView by passing the position, the view and the parent.
       return getView(position, convertView, parent);

    }






}


