package com.terryyamg.wearablelistviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int[] ivItems;
    private String[] tvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivItems = new int[]{R.drawable.google, R.drawable.facebook, R.drawable.twitter}; //圖
        tvItems = new String[]{"Google", "Facebook", "Twitter"}; //文字

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                // Get the list component from the layout of the activity
                WearableListView listView =
                        (WearableListView) stub.findViewById(R.id.wearable_list);

                // Assign an adapter to the list
                listView.setAdapter(new MyAdapter(MainActivity.this, ivItems, tvItems));
                listView.setClickListener(new WearableListView.ClickListener() {
                    @Override
                    public void onClick(WearableListView.ViewHolder viewHolder) {
                        Integer tag = (Integer) viewHolder.itemView.getTag();
                        Toast.makeText(MainActivity.this,tvItems[tag],Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onTopEmptyRegionClick() {

                    }
                });
            }
        });
    }
}
