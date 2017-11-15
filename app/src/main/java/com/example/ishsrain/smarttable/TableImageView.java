package com.example.ishsrain.smarttable;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class TableImageView extends AppCompatImageView {

  int mImage = 0;
  int mSelectImage = 0;
  boolean mSelect = false;

  public TableImageView(Context context) {
    super(context);
  }

  public TableImageView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public TableImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    if(mSelectImage != 0 && mImage != 0) {
      if (mSelect) {
        setImageResource(mSelectImage);
      } else {
        setImageResource(mImage);
      }
    }
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    boolean ret_val = super.onTouchEvent(event);

    if(event.getAction() == MotionEvent.ACTION_DOWN) {
      if(!mSelect) {
        selectImage();
      } else {
        cancelImage();
      }
    }
    return ret_val;
  }

  void selectImage(){
    setImageResource(mSelectImage);
    mSelect = true;
  }

  void cancelImage(){
    setImageResource(mImage);
    mSelect = false;
  }

  void setImage(int resource){
    mImage = resource;
  }

  void setSelectImage(int resource){
    mSelectImage = resource;
  }
}