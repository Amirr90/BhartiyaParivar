package com.e.bhartiyaparivar.utils;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class CustomImageLoader {
    private static final String TAG = "CustomImageLoader";


    @BindingAdapter("android:loadNavImage")
    public static void loadNavImage(ImageView imageView, int imagePath) {
        imageView.setImageResource(imagePath);
        Log.d(TAG, "loadNavImage: " + imagePath);
    }
}
