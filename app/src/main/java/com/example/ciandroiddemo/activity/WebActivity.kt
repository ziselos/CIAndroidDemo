package com.example.ciandroiddemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.ciandroiddemo.Definitions.DefinitionsApi
import com.example.ciandroiddemo.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity  : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webView?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView?.loadUrl(DefinitionsApi.DOMAIN)

    }
}