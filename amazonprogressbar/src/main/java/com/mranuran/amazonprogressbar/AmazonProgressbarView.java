package com.mranuran.amazonprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by dante on 9/3/2017.
 */

public class AmazonProgressbarView extends LinearLayout {
    Context context;
    ImageView imageView;
    int width,height;
    String holderColor="#313131";
    String circleColor="#faee2e";
    RelativeLayout relativeLayout;
    RelativeLayout mainLayout;
    public AmazonProgressbarView(Context context) {
        super(context);
        this.context=context;
        initView(context);
    }

    public AmazonProgressbarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.AmazonProgressbarView,0,0);
        width=typedArray.getInteger(R.styleable.AmazonProgressbarView_holderWidth,200);
        height=typedArray.getInteger(R.styleable.AmazonProgressbarView_holderHeight,200);
        holderColor=typedArray.getString(R.styleable.AmazonProgressbarView_holderColor);
        typedArray.recycle();
        initView(context);
    }


    public AmazonProgressbarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.AmazonProgressbarView,defStyleAttr,0);
        width=typedArray.getInteger(R.styleable.AmazonProgressbarView_holderWidth,200);
        height=typedArray.getInteger(R.styleable.AmazonProgressbarView_holderHeight,200);
        holderColor=typedArray.getString(R.styleable.AmazonProgressbarView_holderColor);
        typedArray.recycle();
        initView(context);
    }



    private void initView(Context context) {
        mainLayout=new RelativeLayout(context);
        RelativeLayout.LayoutParams mainLayoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainLayoutParams);
        mainLayout.setBackgroundColor(Color.parseColor("#33FFFFFF"));
        imageView=new ImageView(context);
        relativeLayout=new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(width,height);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackgroundResource(R.drawable.border);
        GradientDrawable gradientDrawable=(GradientDrawable)relativeLayout.getBackground().getCurrent();
        gradientDrawable.setColor(Color.parseColor(holderColor));
        imageView.setMaxWidth(width-100);
        imageView.setMaxHeight(height-100);
        imageView.setBackgroundResource(R.drawable.circle);
        relativeLayout.addView(imageView);
        mainLayout.addView(relativeLayout);
        addView(mainLayout);
        mainLayout.setVisibility(GONE);
    }

    public void start(){
        this.bringToFront();
        this.setVisibility(VISIBLE);
        mainLayout.setVisibility(VISIBLE);
        Animation animation=AnimationUtils.loadAnimation(context,R.anim.rotation);
        imageView.startAnimation(animation);
    }

    public void stop(){
        if(imageView!=null && mainLayout !=null){
            if(imageView.getAnimation() !=null){
                if(imageView.getAnimation().hasStarted()){
                    imageView.clearAnimation();
                    if(mainLayout.getVisibility()==VISIBLE){
                        mainLayout.setVisibility(GONE);
                        this.setVisibility(GONE);
                    }
                }
            }

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


}
