package zhangty.cn.com.eventdispatcher;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Create by Zhangty on 2018/8/21
 */
public class MyConstrainLayout extends ConstraintLayout {

    public MyConstrainLayout(Context context) {
        super(context);
    }

    public MyConstrainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConstrainLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//
//        Log.e("tag","---------------------onInterceptTouchEvent(MotionEvent ev)----------------------");
////        return super.onInterceptTouchEvent(ev);
////        return true;
//    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        Log.e("tag","---------------------dispatchTouchEvent(MotionEvent ev)----------------------");
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        Log.e("tag","---------------------onTouchEvent(MotionEvent event)----------------------");
////      return super.onTouchEvent(event);
//        return false;
//    }
}
