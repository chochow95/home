package com.example.ratemyclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.graphics.drawable.LayerDrawable;
import android.graphics.Color;
import android.graphics.PorterDuff;

import com.example.ratemyclass.model.Course;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class RateCourse extends AppCompatActivity {

    TextView textView;
    RatingBar ratingBar;
    EditText editText;

    Course course;

    DatabaseReference mCourseReference;
    String courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingclass);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);

        Intent intent = getIntent();
        Gson gson = new Gson();
        course = gson.fromJson(intent.getStringExtra("course"), new TypeToken<Course>(){}.getType());
        courseName = course.getName();

        mCourseReference = FirebaseDatabase.getInstance().getReference("courses");
        textView = findViewById(R.id.textView4);
        ratingBar = findViewById(R.id.ratingBar);
        editText = findViewById(R.id.editText8);

        textView.setText(courseName);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView8.setText(String.valueOf(v));
                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                switch ((int) ratingBar.getRating()) {
                    case 1:

                        stars.getDrawable(2).setColorFilter(Color.parseColor("#FFFFB3"), PorterDuff.Mode.SRC_ATOP);
                        textView8.setText("Very bad");
                        break;
                    case 2:
                        stars.getDrawable(2).setColorFilter(Color.parseColor("#DCAB6B"), PorterDuff.Mode.SRC_ATOP);
                        textView8.setText("Need some improvement");
                        break;
                    case 3:
                        stars.getDrawable(2).setColorFilter(Color.parseColor("#FFCC33"), PorterDuff.Mode.SRC_ATOP);
                        textView8.setText("Good");
                        break;
                    case 4:
                        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                        textView8.setText("Great");
                        break;
                    case 5:
                        stars.getDrawable(2).setColorFilter(Color.parseColor("#7A0019"), PorterDuff.Mode.SRC_ATOP);
                        textView8.setText("Awesome. I love it");
                        break;
                    default:
                        textView8.setText("");
                }
            }
        });

    }

//    public void gotoSearchResults (View view){
//        Intent intent = new Intent(this, SearchResults.class);
//        startActivity(intent);
//    }

    public void gotoSubmitRating (View view){
        float rating = ratingBar.getRating();
        String comment = editText.getText().toString();

        List<Long> ratingsOld = course.getRatings();
        ratingsOld.add((long) rating);
        course.setRatings(ratingsOld);

        List<String> commentsOld = course.getComments();
        commentsOld.add(comment);
        course.setComments(commentsOld);

        Intent intent = new Intent(this, ViewCourse.class);
        intent.putExtra("course", (new Gson()).toJson(course));
        startActivity(intent);
    }
}
