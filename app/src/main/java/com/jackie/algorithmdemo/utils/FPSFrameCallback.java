package com.jackie.algorithmdemo.utils;

import android.util.Log;
import android.view.Choreographer;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/6/3
 */
public class FPSFrameCallback implements Choreographer.FrameCallback {
    private static final String TAG = "FPS_TEST";
    private long mLastFrameTimeNanos;
    private long mFrameIntervalNanos;

    public FPSFrameCallback(long lastFrameTimeNanos) {
        mLastFrameTimeNanos = lastFrameTimeNanos;
        //每一帧渲染时间 多少纳秒
        mFrameIntervalNanos = (long) (1000000000 / 60.0);
    }

    @Override
    public void doFrame(long frameTimeNanos) { //Vsync信号到来的时间frameTimeNanos
        //初始化时间
        if (mLastFrameTimeNanos == 0) {
            //上一帧的渲染时间
            mLastFrameTimeNanos = frameTimeNanos;
        }
        final long jitterNanos = frameTimeNanos - mLastFrameTimeNanos;
        if (jitterNanos >= mFrameIntervalNanos) {
            final long skippedFrames = jitterNanos / mFrameIntervalNanos;
            if (skippedFrames > 5) {
                Log.d(TAG, "Skipped " + skippedFrames + " frames!  "
                    + "The application may be doing too much work on its main thread.");
            }
        }
        mLastFrameTimeNanos = frameTimeNanos;
        //注册下一帧回调
        Choreographer.getInstance().postFrameCallback(this);
    }
}
