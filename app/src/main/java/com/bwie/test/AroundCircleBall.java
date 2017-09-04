package com.bwie.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * name:周振辉
 * 时间：2017/9/4 10:03
 * 类描述：
 */

public class AroundCircleBall extends View {
//    private int mBallColor = Color.BLACK;
//    private float mRadius = 10f;
    private PointF mCircleCenterPoint;
    private Paint mPaint;
    private RingView mBall;
//
//    public AroundCircleBall(Context context) {
//        this(context, null);
//    }
//
//    public AroundCircleBall(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    private void init(){
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//
//        mCircleCenterPoint = new PointF(50 + 10,  60 );
//
//
//
//
//        mBall = new RingView(getContext());
//        mBall.setRadius(10);
//        mBall.setBallColor(mBallColor);
//        //小球的初始位置在圆环的最底部
//        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        params.leftMargin = (int) (50);
//        params.topMargin = (int) (50 * 2);
//        mBall.setLayoutParams(params);
//        addView(mBall);
//    }
//
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//
//
//        //绘制圆
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(50);
//        mPaint.setColor(mBallColor);
//        canvas.drawCircle(mCircleCenterPoint.x, mCircleCenterPoint.y, 50, mPaint);
//        super.onDraw(canvas);
//
//        super.onDraw(canvas);
//    }
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        //测量控件宽高
//        int width = (int) (getPaddingLeft() + 50 * 2 + 50 * 2 + getPaddingRight());
//        int height = (int) (getPaddingTop() + 50 * 2 + 50 * 2 + getPaddingBottom());
//        setMeasuredDimension(width, height);
//    }
//
//
//    /**
//     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
//     */
//    public static int dip2px(Context context, float dpValue) {
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }

        private final Paint paint;
    private final Context context;
    private int borderCol;


    public AroundCircleBall(Context context) {

        // TODO Auto-generated constructor stub
        this(context, null);
        this.borderCol = Color.RED;
    }

    public AroundCircleBall(Context context, AttributeSet attrs) {
        super(context, attrs);


           this.borderCol = Color.RED;



        // TODO Auto-generated constructor stub
        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //消除锯齿
        this.paint.setStyle(Paint.Style.STROKE); //绘制空心圆

    }

    @Override
    protected void onDraw(Canvas canvas) {



        // TODO Auto-generated method stub
        int center = getWidth()/2;
        int innerCircle = dip2px(context, 83); //设置内圆半径
        int ringWidth = dip2px(context, 4); //设置圆环宽度

        //绘制内圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center,center, innerCircle, this.paint);

        //绘制圆环
        this.paint.setARGB(255, 212 ,225, 233);
        this.paint.setStrokeWidth(ringWidth);
        this.paint.setColor(borderCol);
        canvas.drawCircle(center,center, innerCircle+1+ringWidth/2, this.paint);

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        this.paint.setColor(borderCol);
        canvas.drawCircle(center,center, innerCircle+ringWidth, this.paint);


                mBall = new RingView(getContext());
        mBall.setRadius(10);
        mBall.setBallColor(Color.BLUE);
        //小球的初始位置在圆环的最底部
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mBall.setLayoutParams(params);

        super.onDraw(canvas);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public int getBordderColor() {
        return borderCol;
    }

    public void setBorderColor(int newColor) {
        borderCol = newColor;
        invalidate();
        requestLayout();
    }

}
