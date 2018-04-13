/**
 * File: MainActivity.java
 *
 * Author: Amber Brands
 *
 * Date: 13-4-2018
 *
 * Description: This script is part of the application Mr. Potatohead. Initially it displays the
 * toy’s body. This script checks if the user checks/unchecks any of the checkboxes below the toy,
 * and makes the corresponding body part or accessory visible/invisible.
 */

package example.promo.mrpotatohead;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /**
     * Integer array containing ID's of items.
     */
    protected int[] imageID = new int[]{R.id.arms, R.id.ears, R.id.eyebrows, R.id.eyes,
            R.id.glasses, R.id.hat, R.id.mouth, R.id.mustache, R.id.nose, R.id.shoes};

    /**
     * String array containing names of items.
     */
    protected String[] items = new String[]{"arms", "ears", "eyebrows", "eyes", "glasses", "hat",
            "mouth", "mustache", "nose", "shoes"};
    /**
     * Boolean array containing visibility of items.
     */
    protected Boolean[] itemVisible = new Boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){

            /**
             * Loops through different items and checks visibility.
             */
            for (int i = 0; i < 10; i++){
                itemVisible[i] = savedInstanceState.getBoolean(items[i], false);
            }

            /**
             * Makes items visible if respective item was visible in previous activity.
             */
            ImageView image;
            for (int i = 0; i < 10; i++){
                if (itemVisible[i]){
                    image = findViewById(imageID[i]);
                    image.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super

        /**
         * Checks and stores whether items are visible in current state.
         */
        ImageView image;
        for (int i = 0; i < 10; i++){
            image = findViewById(imageID[i]);
            if (image.getVisibility() == View.VISIBLE){
                outState.putBoolean(items[i], true);
            }
        }
    }

    public void checkClicked(View view) {
        Log.d("potato", "checkClicked: ");
        android.widget.CheckBox checkbox = (android.widget.CheckBox) view;
        String item = checkbox.getText().toString();

        /**
         * Checks checkbox and finds corresponding ImageView.
         */
        ImageView image;
        if (Objects.equals(item, "Arms")) {
            image = findViewById(R.id.arms);
        } else if (Objects.equals(item, "Ears")) {
            image = findViewById(R.id.ears);
        } else if (Objects.equals(item, "Eyebrows")) {
            image = findViewById(R.id.eyebrows);
        } else if (Objects.equals(item, "Eyes")) {
            image = findViewById(R.id.eyes);
        } else if (Objects.equals(item, "Glasses")) {
            image = findViewById(R.id.glasses);
        } else if (Objects.equals(item, "Hat")) {
            image = findViewById(R.id.hat);
        } else if (Objects.equals(item, "Mouth")) {
            image = findViewById(R.id.mouth);
        } else if (Objects.equals(item, "Mustache")) {
            image = findViewById(R.id.mustache);
        } else if (Objects.equals(item, "Nose")) {
            image = findViewById(R.id.nose);
        } else {
            image = findViewById(R.id.shoes);
        }

        /**
         * Sets image to visible/invisible depending on current state.
         */
        if (image.getVisibility() == View.INVISIBLE) {
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.INVISIBLE);
        }
    }
}