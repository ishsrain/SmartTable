package com.example.ishsrain.smarttable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import com.example.ishsrain.smarttable.TableImageView.SelectViewListner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
  implements SelectViewListner {

  ArrayList<TableImageView> mSelect = new ArrayList<TableImageView>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int row = 15;
    int col = 11;

    // Table
    TableLayout tableLayout = (TableLayout)findViewById(R.id.TableLayout);

    for(int j=0; j<row; j++) {

      // New Row
      TableRow tableRow = new TableRow(this);

      for (int i = 0; i < col; i++) {

        // New ImageView
        TableImageView imageView = new TableImageView(this);

        // Find ImageID
        String image1Name = "han" + (j * 22 + i * 2);
        String image2Name = "han" + (j * 22 + (i * 2) + 1);
        int image1ID = getResources().getIdentifier(image1Name, "drawable", getPackageName());
        int image2ID = getResources().getIdentifier(image2Name, "drawable", getPackageName());
        imageView.setNormalImageID(image1ID);
        imageView.setSelectImageID(image2ID);

        // Set Image
        imageView.setImage(image1ID);

        // Add ImageView
        tableRow.addView(imageView);

        TableRow.LayoutParams params = (TableRow.LayoutParams) imageView.getLayoutParams();
        params.width = 0;
        params.weight = 1;
        imageView.setAdjustViewBounds(true);
        imageView.setPadding(2,2,2,2);
      }

      // Add Row
      tableLayout.addView(tableRow);
    }
  }

  public void selectView(TableImageView view) {

    for(int i = 0; i<mSelect.size(); i++) {
      mSelect.get(i).cancelImage();
    }

    if(!mSelect.isEmpty()) {
      mSelect.clear();
    }

    mSelect.add(view);
  }
}
