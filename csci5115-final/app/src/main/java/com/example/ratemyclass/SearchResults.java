package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.example.ratemyclass.model.Course;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    private DatabaseReference mCourseReference;
    SearchView searchView;

    List<Course> courseList;
    RecyclerView recyclerView1;

    String searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        courseList = new ArrayList<>();
        searchView = findViewById(R.id.searchView);
        Intent intent = getIntent();
        searchString = intent.getStringExtra("searchString");
        searchView.setQuery(searchString, false);

        final String[] keywords = searchString.split(" ");

        mCourseReference = FirebaseDatabase.getInstance().getReference("courses");

        ValueEventListener courseListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    for (int i = 0; i < keywords.length; i++) {
                        Course course = snapshot.getValue(Course.class);
                        if (course.toString().toLowerCase().contains(keywords[i].toLowerCase()))
                            courseList.add(course);
                    }
                }

                recyclerView1.setAdapter(new CourseAdapter(SearchResults.this, courseList));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("test", "Database error occurred");
            }
        };

        mCourseReference.addListenerForSingleValueEvent(courseListener);

        recyclerView1 = findViewById(R.id.recycler1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        CourseAdapter adapter1 = new CourseAdapter(this, courseList);
        recyclerView1.setAdapter(adapter1);

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

    @Override
    public void onStart() {
        super.onStart();
    }

}