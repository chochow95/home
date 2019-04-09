package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.view.View;


public class Homepage extends AppCompatActivity {

    SearchView searchView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        searchView = (SearchView)findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                        intent.putExtra("query", query);
                        startActivity(intent);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                }
        );


    }


    public void gotoAdvancedSearch (View view){
        Intent intent = new Intent(this, AdvancedSearch.class);
        startActivity(intent);
    }
    public void gotoAboutus (View view){
        Intent intent = new Intent(this, Aboutus.class);
        startActivity(intent);
    }

}
