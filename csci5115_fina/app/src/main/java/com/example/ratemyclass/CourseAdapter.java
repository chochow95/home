package com.example.ratemyclass;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ratemyclass.model.Course;
import com.google.gson.Gson;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;

    //we are storing all the products in a list
    private List<Course> courseList;

    //getting the context and product list with constructor
    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_courses, parent,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        //getting the product of the specified position
        final Course course = courseList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(course.getTitle());
        holder.textViewName.setText(course.getName());

        double rating = course.getAverageRating();
        String ratingStr;
        if (rating == -1) {
            ratingStr = "N/A";
        } else {
            ratingStr = Double.toString(rating);
        }
        holder.textViewRating.setText(ratingStr);

        holder.buttonView.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewCourse.class);
                intent.putExtra("course", (new Gson()).toJson(course));
                context.startActivity(intent);
            }
        });

        holder.buttonRate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, RateCourse.class);
                intent.putExtra("course", (new Gson()).toJson(course));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle, textViewName, textViewRating;
        public Button buttonView, buttonRate;

        public CourseViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            buttonView = itemView.findViewById(R.id.buttonView);
            buttonRate = itemView.findViewById(R.id.buttonRate);
        }
    }
}
