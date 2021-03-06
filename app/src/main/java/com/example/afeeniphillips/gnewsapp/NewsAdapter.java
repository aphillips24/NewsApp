package com.example.afeeniphillips.gnewsapp;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class NewsAdapter extends ArrayAdapter<News> {


    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    public NewsAdapter(Activity context, ArrayList<News> News) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, News);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the current position of News
        final News currentNews = getItem(position);
        Log.i(LOG_TAG, "Item number " + position);


        // Find the TextView in the list_item.xml (mapping)
        TextView titleNewsTextView = (TextView) listItemView.findViewById(R.id.news_title);
        TextView authorNewsTextView = (TextView) listItemView.findViewById(R.id.author_news);
        ImageView thumbnailImageView = (ImageView) listItemView.findViewById(R.id.thumbnail_image);
        TextView sectionNewsTextView = (TextView) listItemView.findViewById(R.id.section_type);
        TextView publicationDateTextView = (TextView) listItemView.findViewById(R.id.publicationDate);


        // Set proper value in each fields
        assert currentNews != null;
        titleNewsTextView.setText(currentNews.getTitle());
        authorNewsTextView.setText(currentNews.getAuthor());
        Picasso.with(getContext()).load(currentNews.getThumbUrl()).into(thumbnailImageView);
        sectionNewsTextView.setText(String.valueOf(currentNews.getSection()));
        publicationDateTextView.setText(String.valueOf(currentNews.getDate()));

        Log.i(LOG_TAG, "ListView has been returned");
        return listItemView;

    }

}