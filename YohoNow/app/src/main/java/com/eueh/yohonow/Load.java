package com.eueh.yohonow;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by dllo on 16/12/6.
 */

public class Load extends ImageView implements SwipeTrigger,SwipeLoadMoreTrigger{
    public Load(Context context) {
        super(context);
    }

    public Load(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {

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
