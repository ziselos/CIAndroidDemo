package com.example.ciandroiddemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.ciandroiddemo.activity.javascript.JavaScriptHelper
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    val urlToShow =
        "https://www.protothema.gr/world/article/892906/skandalo-ibiza-stin-austria-sex-kai-narkotika-sto-video-pou-ekapse-ton-adikagelario/app"

    val captureEvent =
        "javascript: (function() {document.addEventListener('click', function (event) { event.preventDefault(); var anchor = event.target.closest(\"a\");  console.log( anchor.getAttribute('href'));  Android.showToast(anchor.getAttribute('href'));}, true);})()\n"

    @SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        WebView.setWebContentsDebuggingEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(com.example.ciandroiddemo.R.layout.activity_web)
        webView?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                Log.d("Web Req ->", request.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webView.loadUrl(captureEvent)

            }

        }
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.allowFileAccess = true
        webView?.settings?.allowFileAccessFromFileURLs = true


        webView.loadUrl(urlToShow)

        webView.addJavascriptInterface(JavaScriptHelper(this), "Android")

        //webView?.loadUrl("file:///android_asset/sample.html")
    }

}