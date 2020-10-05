package com.example.ppnd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.ViewHolder> {

    private ArrayList<VolunteerData> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView1, mTextView2, mTextView3;

        public ViewHolder(View view) {
            super(view);

            mTextView1 = (TextView)view.findViewById(R.id.volunteer_title);
            mTextView2 = (TextView)view.findViewById(R.id.volunteer_date);
            mTextView3 = (TextView)view.findViewById(R.id.volunteer_writer);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VolunteerAdapter(ArrayList<VolunteerData> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VolunteerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_voulnteer, parent, false);
        // set the view's size, margins, paddings and layout parameters...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.mTextView1.setText(mDataset.get(position).getTitle());
        holder.mTextView2.setText(mDataset.get(position).getDate());
        holder.mTextView3.setText(mDataset.get(position).getWriter());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

class VolunteerData {
    private String title, date, writer;
    public VolunteerData(String title, String date, String writer){
        this.title = title;
        this.date = date;
        this.writer = writer;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getWriter(){
        return writer;
    }
}


