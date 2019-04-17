package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Button;
import android.view.View;
import android.widget.ViewSwitcher;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Gravity;

public class Homepage extends AppCompatActivity {

    SearchView searchView;
    Button button;
    ImageSwitcher imageSwitcher;
    ImageView next;
    TextSwitcher textSwitcher;

    Integer[] images={R.drawable.english, R.drawable.math,R.drawable.economic};
    String[]  strings= {"Math 1271 Calculus I", "ENGL 3601 Analysis of the English Language", "ECON 1001  Principles of Microeconomics"};

    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        searchView = (SearchView)findViewById(R.id.searchView);
        searchView.setQueryHint("Search for Courses");
        searchView.setIconifiedByDefault(false);
        if(!searchView.isFocused()) {
            searchView.clearFocus();
        }

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
//                // set displayed text size
                textView.setTextSize(13);

                return textView;
            }
        });

        imageSwitcher.setImageResource(images[0]);
        textSwitcher.setText(strings[0]);

        next =(ImageView) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                if(i<images.length-1){
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                    textSwitcher.setText(strings[i]);
                }
                else{
                    i=0;
                    imageSwitcher.setImageResource(images[0]);
                    textSwitcher.setText(strings[0]);
                }
            }
        });

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                        intent.putExtra("searchString", query);
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
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

}
