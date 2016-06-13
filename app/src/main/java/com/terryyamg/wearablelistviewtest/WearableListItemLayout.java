package com.terryyamg.wearablelistviewtest;

import android.content.Context;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WearableListItemLayout extends LinearLayout
        implements WearableListView.OnCenterProximityListener {

    private CircledImageView mImageView;
    private TextView mTextView;

    public WearableListItemLayout(Context context) {
        this(context, null);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);

    }

    // Get references to the icon and text in the item layout definition
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // These are defined in the layout file for list items
        // (see next section)
        mImageView = (CircledImageView) findViewById(R.id.iv);
        mTextView = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onCenterPosition(boolean animate) {
        //在中間
        mImageView.setScaleX(1f);
        mImageView.setScaleY(1f);
        mTextView.setAlpha(1f);
    }

    @Override
    public void onNonCenterPosition(boolean animate) {
        //其他部分 圖縮小 文字透明一半
        mImageView.setScaleX(0.8f);
        mImageView.setScaleY(0.8f);
        mTextView.setAlpha(0.5f);
    }
}

