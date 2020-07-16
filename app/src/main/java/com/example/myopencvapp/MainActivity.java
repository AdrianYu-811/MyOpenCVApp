package com.example.myopencvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


import java.io.IOException;

//This is Adrian's project

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                int [] r= getArray3d(2,1);
                Log.d("hi",""+r[1]);
                try {
                    Mat img = Utils.loadResource(MainActivity.this,R.drawable.opencv, CvType.CV_8UC4);
                    Log.d("adrian","channel"+img.size());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    int [] getArray3d(int x, int y){
        int [][][] array3d = new int[5][5][5];

        for (int i =0; i<5; i++){
            for (int j=0; j<5; j++){
                for (int k=0; k<5; k++){
                    array3d[i][j][k] = i+j+k;
                }
            }
        }
        return array3d[x][y];
    }
}
