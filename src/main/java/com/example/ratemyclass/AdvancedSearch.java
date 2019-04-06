package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdvancedSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
    }

    public void gotoHomepage (View view){
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void gotoSearchresult (View view){
        Intent intent = new Intent(this, SearchResults.class);
        startActivity(intent);
    } // need more fuctional code        GO BUTTON to the searchresult

}
