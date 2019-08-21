package com.example.loginfeature.ui

import android.app.Dialog
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.loginfeature.BuildConfig
import com.example.loginfeature.R
import com.example.loginfeature.api.RedditLoginRestApi
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import java.util.*


class LoginActivity : DaggerAppCompatActivity() {

    lateinit var auth_dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_login_activity)

        auth.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // TODO Auto-generated method stub
                auth_dialog = Dialog(this@LoginActivity)
                auth_dialog.setContentView(R.layout.auth_dialog)
                var web = auth_dialog.findViewById(R.id.webv) as WebView
                web.settings.javaScriptEnabled = true
                val url = RedditLoginRestApi.getAuthUrl(
                    BuildConfig.RedditApplicationKey,
                    UUID.randomUUID().toString(),
                    BuildConfig.RedditRedirectUrl
                )
                web.loadUrl(url)
                web.setWebViewClient(object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                        view.loadUrl(url)
                        return true
                    }

                    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                        super.onPageStarted(view, url, favicon)

                    }

                    override fun onPageFinished(view: WebView, url: String) {
                        super.onPageFinished(view, url)

                        if (url.contains("?code=") || url.contains("&code=")) {

                            val uri = Uri.parse(url)
                            var authCode = uri.getQueryParameter("code")

                            auth_dialog.dismiss()

                        } else if (url.contains("error=access_denied")) {
                            auth_dialog.dismiss()
                        }
                    }
                })
                auth_dialog.show()
                auth_dialog.setTitle("Authorize")
                auth_dialog.setCancelable(true)

            }
        })

    }

}