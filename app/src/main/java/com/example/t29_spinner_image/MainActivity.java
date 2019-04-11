package com.example.t29_spinner_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare the titles, images and population
    String[] spinnerTitles;
    String[] spinnerPopulation;
    int[] spinnerImages;
    Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //initialize the titles, images and population.
        spinnerTitles = new String[]{ "Israel", "Brazil", "China", "France","Australia", "India", "Ireland", "Italy", "Mexico", "Poland"};
        spinnerPopulation = new String[]{"8.972 Million", "207.7 Million", "1.379 Billion", "66.9 Million", "24.13 Million", "1.324 Billion", "4.773 Million", "60.6 Million", "127.5 Million", "37.95 Million"};
        spinnerImages = new int[]{R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil
                , R.drawable.flag_brazil};


        mSpinner=(Spinner) findViewById(R.id.spinner);

        //Initialize the spinner and the custom adapter--- by using the constructor from CustomAdapter class
        CustomAdapter mCustomAdapter = new CustomAdapter(MainActivity.this, spinnerTitles, spinnerImages, spinnerPopulation);
        mSpinner.setAdapter(mCustomAdapter);


        

        //Allow the user to tap on the items in the spinner by using
        // Spinner.setOnItemSelectedListener and show the selected item in an Android toast message.

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //We will use the boolean variable isUserInteracting inside android spinner onItemSelected method to show the toast message.
                if (isUserInteracting) {
                    Toast.makeText(MainActivity.this, spinnerTitles[position], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    //if we don't use this method, when we run the app, we will immediately see Android toast message containing spinner item
    // appears on the screen without making any selection! To prevent that from happening,
    // we need to override a method called onUserInteraction. This method is used to detect
    // that the user have interacted with the device while the activity is still running.
    @Override
    public void onUserInteraction(){
        super.onUserInteraction();
        //initialize isUserInteracting parameter
        isUserInteracting = true;
    }

    //isUserInteracting is initialize on the method onUserInteraction
    private boolean isUserInteracting;



}
