package com.example.ratemyclass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourseViewHolder extends RecyclerView.ViewHolder {

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
