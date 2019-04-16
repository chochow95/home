package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ratemyclass.model.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ViewCourse extends AppCompatActivity {

    RecyclerView recyclerView;

    TextView textViewTitle, textViewName, textViewAverageRating;
    Button buttonRate;

    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);

        Intent intent = getIntent();
        Gson gson = new Gson();
        course = gson.fromJson(intent.getStringExtra("course"), new TypeToken<Course>(){}.getType());

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewName = findViewById(R.id.textViewName);
        textViewAverageRating = findViewById(R.id.textViewAverageRating);

        textViewTitle.setText(course.getTitle());
        textViewName.setText(course.getName());
        textViewAverageRating.setText(Double.toString(course.getAverageRating()));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CommentAdapter adapter = new CommentAdapter(this, course.getComments());

        recyclerView.setAdapter(adapter);
    }

    // TODO:  do we like where this button is?
    public void gotoSearchResults (View view){
        Intent intent = new Intent(this, SearchResults.class);
        startActivity(intent);
    }

    public void goToRating (View view){
        Intent intent = new Intent(this, RateCourse.class);
        intent.putExtra("course", (new Gson()).toJson(course));
        startActivity(intent);
    }
}
