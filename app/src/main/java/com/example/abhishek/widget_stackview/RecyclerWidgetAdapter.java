package com.example.abhishek.widget_stackview;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

/**
 * Created by abhishek on 30/4/16.
 */
public class RecyclerWidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    private ArrayList<Content> content = new ArrayList<>();
    Content contents = new Content();
    private Context context = null;
    private int appWidgetId;

    public RecyclerWidgetAdapter(Context context, Intent intent) {
        this.context = context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);

        populateListItem();
    }

    private void populateListItem() {

        for (int i = 0; i < 5; i++) {
            contents.desc = "Best Collections of Bike Accessories Helmets and Spares starting from 99 only";
            contents.resources = R.drawable.image;
            content.add(contents);


        }
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return content.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /*
    *Similar to getView of Adapter where instead of View
    *we return RemoteViews
    *
    */
    @Override
    public RemoteViews getViewAt(int position) {
        final RemoteViews remoteView = new RemoteViews(
                context.getPackageName(), R.layout.widget_card);

        Bitmap placeholderBitmap = BitmapFactory.decodeResource(context.getResources(), content.get(position).resources);

        remoteView.setImageViewBitmap(R.id.textView,placeholderBitmap);

        return remoteView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
