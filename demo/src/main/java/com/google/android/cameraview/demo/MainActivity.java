
package com.google.android.cameraview.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.FaceDetector;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.tzutalin.dlib.Constants;
import com.tzutalin.dlib.FaceRec;
import com.tzutalin.dlib.VisionDetRet;

import java.io.Console;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView uiimage;
        @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            uiimage=(ImageView)findViewById(R.id.uiimage);
            FaceRec rec= new FaceRec(Constants.getDLibDirectoryPath());
            Bitmap img = BitmapFactory.decodeResource(this.getResources(),R.drawable.friends);
                List<VisionDetRet> list =rec.detect(img);
                for (VisionDetRet x:list){


                    int width=x.getRight()-x.getLeft();
                    int height=x.getBottom()-x.getTop();
                    Log.i("mylog","values"+width+"hei"+height);
                  Bitmap temp=  Bitmap.createBitmap(img,x.getLeft(),x.getTop(),width,height);
                    uiimage.setImageBitmap(temp);


                }

//                        Bitmap img = BitmapFactory.decodeResource(this.getResources(),R.drawable.friends);
//            int width=img.getWidth();
//            int height=img.getHeight();
//            FaceDetector detector= new FaceDetector(width,height,5);

//
//            detector.findFaces(img,faces);
//            for (FaceDetector.Face obj:faces) {
//                Log.i("mylog","faces found");
//            }
//


//            FaceRec rec= new FaceRec(Constants.getDLibDirectoryPath());
//            rec.train();
//            Log.i("mylog","Trained");
//
//            Bitmap img = BitmapFactory.decodeResource(this.getResources(),R.drawable.vikrantimage);
//            List<VisionDetRet> results=rec.recognize(img);
//            Log.i("mylog","is match found "+results.size());
//
//            for(VisionDetRet n:results){
//                Log.i("mylog","inside the loop");
//                Toast.makeText(this,"reslut"+n.getLabel(),Toast.LENGTH_SHORT).show();
//
//             }
//            Log.i("mylog","outside the loop");
//        }



        }
    }
