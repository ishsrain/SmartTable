package com.example.ishsrain.smarttable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TableImageView extends AppCompatImageView {

  int mImage = 0;
  int mSelectImage = 0;
  boolean mSelect = false;

  SelectViewListner mCallback;

  public TableImageView(Context context) {
    super(context);

    mCallback = (SelectViewListner) context;

    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!mSelect) {
          selectImage();
        } else {
          cancelImage();
        }
      }
    });
  }

  public TableImageView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public TableImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

  }

  void selectImage(){
    setImage(mSelectImage);
    mSelect = true;
    mCallback.selectView(this);
  }

  void cancelImage(){
    setImage(mImage);
    mSelect = false;
  }

  void setNormalImageID(int resource){
    mImage = resource;
  }

  void setSelectImageID(int resource){
    mSelectImage = resource;
  }

  void setImage(int resource) {

//    setImageResource(resource);

    Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
    Bitmap resizeBitmap = Bitmap.createScaledBitmap(bmp, 100, 100, true);
//    bmp.recycle();
//    BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
//    if(bitmapDrawable != null) {
//      Bitmap currentBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
//      if (currentBitmap != null) {
//        currentBitmap.recycle();
//      }
//    }
    setImageBitmap(resizeBitmap);
  }

  public interface SelectViewListner {
    void selectView(TableImageView view);
  }
}