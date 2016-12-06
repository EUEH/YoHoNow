package com.eueh.yohonow.loadingdata;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.eueh.yohonow.R;

/**
 * Created by dllo on 16/12/6.
 */

public class Load extends ImageView implements SwipeLoadMoreTrigger,SwipeTrigger{
    public Load(Context context) {
        super(context);
    }

    public Load(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {

        setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onMove(int i, boolean b, boolean b1) {

    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onReset() {

    }
}
