package com.example.ratemyclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context mCtx;
    private List<String> comments;

    public CommentAdapter(Context mCtx, List<String> comments) {
        this.mCtx = mCtx;
        this.comments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_comments, null, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.textViewComment.setText(comments.get(position));
    }

    @Override
    public int getItemCount() {
//        return comments.size();

        if (comments != null) {
            return comments.size();
        }
        return 0;
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            textViewComment = itemView.findViewById(R.id.textViewComment);
        }
    }
}
