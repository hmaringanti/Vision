package com.example.bribe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

        	public class rating extends AppCompatActivity {

        	    RatingBar ratingBar;
	    TextView textView;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.activity_main);

        	        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        	        textView = (TextView) findViewById(R.id.textView31);

        	    }

        	    public void onSubmit(View view){
        	        float ratingValue = ratingBar.getRating();

        	        if(ratingValue < 2){
            	            textView.setText("Rating: "+ratingValue+"\nIs it that worse?");
            	        }

        	        else if(ratingValue <= 3 && ratingValue >= 2){
            	            textView.setText("Rating: "+ratingValue+"\nWe will try to be better !");
            	        }

        	        else if(ratingValue > 3 && ratingValue <= 4){
            	            textView.setText("Rating: "+ratingValue+"\nThat means you are having a good time here :)");
            	        }

        	        else if(ratingValue > 4){
            	            textView.setText("Rating: "+ratingValue+"\nWow! We will keep up the good work ;)");
            	        }
            }

        	}