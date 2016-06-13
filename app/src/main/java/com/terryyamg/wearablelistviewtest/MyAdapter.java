package com.terryyamg.wearablelistviewtest;

import android.content.Context;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends WearableListView.Adapter {
    private int[] mImage;
    private String[] mDataset;
    private final Context mContext;
    private final LayoutInflater mInflater;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context,int[] imageData, String[] dataset) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mImage = imageData;
        mDataset = dataset;
    }

    // Provide a reference to the type of views you're using
    public static class ItemViewHolder extends WearableListView.ViewHolder {
        private CircledImageView imageView;
        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            // find the text view within the custom item's layout
            imageView = (CircledImageView) itemView.findViewById(R.id.iv);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    // Create new views for list items
    // (invoked by the WearableListView's layout manager)
    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // 對應list_item layout
        return new ItemViewHolder(mInflater.inflate(R.layout.list_item, null));
    }

    // Replace the contents of a list item
    // Instead of creating new views, the list tries to recycle existing ones
    // (invoked by the WearableListView's layout manager)
    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder,
                                 int position) {
        // retrieve the text view
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        CircledImageView iv = itemHolder.imageView;
        TextView view = itemHolder.textView;
        // 放入圖片、文字
        iv.setImageResource(mImage[position]);
        view.setText(mDataset[position]);
        // 設定tag id
        holder.itemView.setTag(position);
    }

    // Return the size of your dataset
    // (invoked by the WearableListView's layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
