package com.example.ratemyclass;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ImageButton;

public class AdvancedSearch extends AppCompatActivity {

    EditText editViewName, editViewNumber, editViewMinRating, editViewDept;
    RadioGroup radioGroup;
    ImageButton imageButton,imageButton3;

//    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);

//        context = this;

        editViewName = findViewById(R.id.editViewName);
        editViewNumber = findViewById(R.id.editViewNumber);
        editViewMinRating = findViewById(R.id.editViewMinRating);
        editViewDept = findViewById(R.id.editViewDept);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);



        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get contents of all textviews and send to search results
                Intent intent = new Intent(getApplicationContext(), SearchResults.class);

                String name, number, department, minRating;
                name = editViewName.getText().toString();
                number = editViewNumber.getText().toString();
                department = editViewDept.getText().toString();
                minRating = editViewMinRating.getText().toString();

                String[] sb = {name, number, department};

                intent.putExtra("searchString", TextUtils.join(" ", sb));

                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editViewName.setText("");
                editViewNumber.setText("");
                editViewDept.setText("");
                editViewMinRating.setText("");
                radioGroup.clearCheck();
            }});




    }

}

