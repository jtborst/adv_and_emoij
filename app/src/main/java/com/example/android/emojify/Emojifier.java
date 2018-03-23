package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by jtborst on 23/03/2018.
 */

public class Emojifier {

    private static final String TAG = Emojifier.class.getCanonicalName();

    public static int detectFaces(Context context, Bitmap image) {
        int numberOfFaces = 0;

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .build();
        Frame frame = new Frame.Builder().setBitmap(image).build();
        SparseArray<Face> faces = detector.detect(frame);
        numberOfFaces = faces.size();

        Log.i(TAG, "found " + numberOfFaces + " faces");

        detector.release();

        return numberOfFaces;
    }
}
