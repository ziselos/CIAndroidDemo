package com.example.ciandroiddemo.activity.javascript

import android.content.Context
import android.util.Log
import android.widget.Toast
import android.webkit.JavascriptInterface


class JavaScriptHelper
/** Instantiate the interface and set the context  */
internal constructor(private var mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Log.d("Helper ->", toast)
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }


    @JavascriptInterface
    fun showText(toast: String) {
        Log.d("Helper ->", toast)
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}