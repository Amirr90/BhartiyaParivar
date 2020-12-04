package com.e.bhartiyaparivar.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    public static final String MOBILE_NUMBER_KEY = "mobile";


    public static ProgressDialog progressDialog;

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static void showProgressDialog(Activity activity, String msg) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    public static void showProgressDialog(Activity activity, String msg, boolean isCancelable) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(isCancelable);
        progressDialog.show();
    }

    public static void hideProgressDialog() {
        if (null != progressDialog) {
            progressDialog.dismiss();
        }
    }
}
