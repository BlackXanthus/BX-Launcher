package psy23.launcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by pkb on 28/08/16.
 */
public class RelativeViewWithTouch extends RelativeLayout {

    protected Context myContext;
    float mLastX;
    float mLastY;
    float mStartY;
    boolean mIsBeingDragged;
    float mTouchSlop;


    public RelativeViewWithTouch(Context context) {
        this(context, null, 0);
    }

    public RelativeViewWithTouch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RelativeViewWithTouch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myContext=context;
        mTouchSlop= ViewConfiguration.get(context).getScaledTouchSlop();
       // init(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        Context context = myContext;
       // CharSequence text = "We could have intercepted this touch event";
       // int duration = Toast.LENGTH_SHORT;
       // Toast myToast = Toast.makeText(context,text,duration);
       // myToast.show();

        /**
         * This now correctly allows vertical scrolling, while catching
         * the "Swipe".
         *
         * Code Modified from: http://neevek.net/posts/2013/10/13/implementing-onInterceptTouchEvent-and-onTouchEvent-for-ViewGroup.html
         */
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                mStartY = mLastY;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                float xDelta = Math.abs(x - mLastX);
                float yDelta = Math.abs(y - mLastY);

                float yDeltaTotal = y - mStartY;
                float xDeltaTotal = x - mLastX;

                //scrolling, do not want
                if (yDelta > xDelta && Math.abs(yDeltaTotal) > mTouchSlop) {
                    mIsBeingDragged = true;
                    mStartY = y;

                    CharSequence text = "Vertical Scrolling";
                    int duration = Toast.LENGTH_SHORT;
                    Toast myToast = Toast.makeText(context,text,duration);
                    myToast.show();

                    return false;
                }

                if (xDelta > yDelta && Math.abs(xDeltaTotal) > mTouchSlop) {

                    mIsBeingDragged = true;
                    mStartY = y;

                    CharSequence text = "Horizontal Scrolling";
                    int duration = Toast.LENGTH_SHORT;
                    Toast myToast = Toast.makeText(context,text,duration);
                    myToast.show();

                    return true;

                }

                break;
        }

        return false;

    }

}
