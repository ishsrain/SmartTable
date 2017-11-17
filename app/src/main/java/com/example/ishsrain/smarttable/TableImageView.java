package com.example.ishsrain.smarttable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

public class TableImageView extends AppCompatImageView {

  int mImage = 0;
  int mSelectImage = 0;
  boolean mSelect = false;

  String mStr;
  char mCh1;
  char mCh2;
  char mCh3;

  SelectViewListener mCallback;

  public TableImageView(Context context) {
    super(context);

    mCallback = (SelectViewListener) context;

    setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!mSelect) {
          selectImage();
          mCallback.selectView((TableImageView)view);
        } else {
          cancelImage();
          mCallback.selectView((TableImageView)view);
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
  }

  void cancelImage(){
    setImage(mImage);
    mSelect = false;
  }

  void setNormalImageID(int resource){
    mImage = resource;
  }

  int getNormalImageID(){
    return mImage;
  }

  void setSelectImageID(int resource){
    mSelectImage = resource;
  }

  int getSelectImageID(){
    return mSelectImage;
  }

  void setString(String text) {
    mStr = text;
  }

  void setChar(char cho, char jung, char jong) {
    mCh1 = cho;
    mCh2 = cho;
    mCh3 = cho;
  }

  void setImage(int resource) {

//    setImageResource(resource);

    Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
    Bitmap resizeBitmap = Bitmap.createScaledBitmap(bmp, bmp.getWidth()/4, bmp.getHeight()/4, true);
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

  public interface SelectViewListener {
    void selectView(TableImageView view);
  }
}