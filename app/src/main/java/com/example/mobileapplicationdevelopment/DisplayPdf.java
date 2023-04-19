package com.example.mobileapplicationdevelopment;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
public class DisplayPdf extends AppCompatActivity {
    private HashMap<String, String> myMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaypdf);

        myMap.put("Layouts","19dAzzjGsmAZUDfv5t4Znj6IF5aYIsxDh");
        myMap.put("linearLayout","1wK-iSHYxCkVTSvydBAzZgmKXnwCrLjwa");
        myMap.put("relativeLayout","1ip54tnBkdbvkaCxWJ9tJzdjmHEZiSm-K");
        myMap.put("absoluteLayout","1wi3xtjqgu535yHsGBliObrcRqh8mnstD");
        myMap.put("tableLayout","1zmrIJukh2q1QMdoTUl6kPtS1bcdIpDa1");
        myMap.put("gridLayout","1I1v8uUak9bDUP6d4ZhkLp3zZuOMoi-gn");
        myMap.put("frameLayout","1-tw8rXHndtxnsqXPeeOi1x6SC2dgKHiZ");

//        View

        myMap.put("allViews","1p99zz1-KGnsd1Vwn_vhSk9aSdgjv7aXL");
        myMap.put("textview","1PFODM2rCaOgOReW3YgJlIqDvwdeIr-4w");
        myMap.put("editview","1hZ9LSWwlheM0q8A9Ve-lJTYflutwgU9S");
        myMap.put("imageview","1TwVsU-wHmXeijxUKc3P31kbTjjvacidr");
        myMap.put("imagebutton","1zvpk1M1W3X4SdenOwTp6kULe_Z0B1lMc");
        myMap.put("buttonview","1ao5LgK-sAp6CRHv0-Bt-FBFWr0NfdZKK");
        myMap.put("togglebutton","1DZHv7QmytfrpGwS1mUvbfaBHje4XQxWz");
        myMap.put("checkbox","1V2Xuob2nJ8Q5jz3w4aSFjDZ4A3199qXX");

// life cycle
        myMap.put("lifecycle","1VCpoids8wPfaOP15BKmTFXwIgAMlZmEU");
//artchitucture
        myMap.put("architecture","1n8Aa2OZ4vi6b4r5M1LT5c_3CUodSqVb2");




        final String pdfid = myMap.get(getIntent().getStringExtra("doc_name"));

        WebView webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(("https://drive.google.com/file/d/"+pdfid+"/view"));
        Button download = findViewById(R.id.btn_download);
        download.setVisibility(View.VISIBLE);
        download.setOnClickListener(v -> {
            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse("https://drive.google.com/uc?id=" + pdfid);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getIntent().getStringExtra("doc_name"));
            downloadManager.enqueue(request);
        });
    }

    @Override
    public void onBackPressed() {
        WebView webView = findViewById(R.id.webview);
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

