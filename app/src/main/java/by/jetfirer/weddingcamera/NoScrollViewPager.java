package by.jetfirer.weddingcamera;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Konstantin on 04.05.2017.
 */

public class NoScrollViewPager extends ViewPager {

    private boolean isPagingEnable = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isPagingEnable && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isPagingEnable && super.onInterceptTouchEvent(ev);
    }

    public void setPagingEnable(boolean pagingEnable) {
        isPagingEnable = pagingEnable;
    }
}
