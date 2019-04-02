package com.example.myplants;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.myplants.R.id.plant_info_hint_txt;

public class PlantInfoActivity extends OptionsMenuActivity implements PlantNamesFragment.PlantListener {
    private static final String TAG= "PlantInfo";
    TextView lightRequirementDetails;
    TextView waterRequirementDetails;
    TextView funFactsDetails;
    TextView lightRequirement_txt;
    TextView waterRequirement_txt;
    TextView funFacts_txt;
    TextView hint_txt;
    ImageView plantImage;
    private FloatingActionButton btnAddFavourite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("PLANT INFO");

        lightRequirementDetails = findViewById(R.id.light_requirements);
        waterRequirementDetails = findViewById(R.id.water_requirements);
        funFactsDetails = findViewById(R.id.fun_fact);

        lightRequirement_txt = findViewById(R.id.light_requirements_txt);
        waterRequirement_txt = findViewById(R.id.water_requirements_txt);
        funFacts_txt = findViewById(R.id.fun_facts_txt);
        hint_txt = findViewById(plant_info_hint_txt);

        plantImage = findViewById(R.id.plant_image);

        btnAddFavourite = (FloatingActionButton) findViewById(R.id.btnAddFavourite);
        btnAddFavourite.hide();

    }

    // method sets a description to the 'plantDetails Textview' when a plant is selected
    @Override
    public void onPlantSelected(int index) {

        lightRequirement_txt.setText("Light Requirements");
        String [] lightRequirements= getResources().getStringArray(R.array.lightRequirements);
        lightRequirementDetails.setText(lightRequirements[index]);

        waterRequirement_txt.setText("Water Requirements");
        String [] waterRequirements= getResources().getStringArray(R.array.waterRequirements);
        waterRequirementDetails.setText(waterRequirements[index]);

        funFacts_txt.setText("Fun Fact");
        String [] funFacts =getResources().getStringArray(R.array.funFacts);
        funFactsDetails.setText(funFacts[index]);

        hint_txt.setText("");

        Drawable d=getResources().obtainTypedArray(R.array.plantimages).getDrawable(index);
        plantImage.setImageDrawable(d);

        btnAddFavourite.show();
        final int favIndex = index;

        btnAddFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] favourites = getResources().getIntArray(R.array.favourites);

                    favourites [favourites.length-1] = favIndex;
                    Log.v(TAG,"favourites"+favourites );
            }
        });

    }

}

