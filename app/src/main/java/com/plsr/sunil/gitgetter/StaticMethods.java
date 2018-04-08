package com.plsr.sunil.gitgetter;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sunil on 4/8/18.
 */

public class StaticMethods {
    public static void displayToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        context = null;
    }
}
