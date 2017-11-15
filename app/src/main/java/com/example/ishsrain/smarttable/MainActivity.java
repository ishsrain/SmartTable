package com.example.ishsrain.smarttable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] str = {"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"};
    for(int j=0; j<str.length; j++) {
      for (int i = 0; i < 10; i++) {
        // Resource ID
        String viewID = "imageView" + ((j+1)*10 + i + 1);
        int resourceID = getResources().getIdentifier(viewID, "id", getPackageName());

        // Image ID
        String image1Name = str[j] + ((i * 2) + 1);
        String image2Name = str[j] + ((i * 2) + 2);
        int image1ID = getResources().getIdentifier(image1Name, "drawable", getPackageName());
        int image2ID = getResources().getIdentifier(image2Name, "drawable", getPackageName());

        TableImageView imageView = (TableImageView) findViewById(resourceID);
        imageView.setImage(image1ID);
        imageView.setSelectImage(image2ID);
      }
    }
  }
}
