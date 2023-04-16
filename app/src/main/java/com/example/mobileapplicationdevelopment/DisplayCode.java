package com.example.mobileapplicationdevelopment;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mobileapplicationdevelopment.component.elements.Edit_Text;
import com.example.mobileapplicationdevelopment.component.elements.Image_View;
import com.example.mobileapplicationdevelopment.component.elements.Text_View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


public class DisplayCode extends AppCompatActivity {
    static HashMap<String, String> myMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_code);
        ImageView loader = findViewById(R.id.loader);
        Glide.with(this).load(R.drawable.loader).into(loader);
        Button copy = findViewById(R.id.copy);
        TextView code = findViewById(R.id.code);

        myMap.put("linear_java", "13XbwTxuzyGsERyoFaQcGammxLlIQIxXs");
        myMap.put("linear_xml", "16epbYNecX086aRsPX97nmJsAmOU9PHtu");
        myMap.put("relative_java", "1jgEZAf4k-masxSN5ssTE4yX952q1LEe9");
        myMap.put("relative_xml", "1Wmx72mcg9WnquemM6gmzn87OfF8ONy08");
        myMap.put("absolute_java", "1ot91HcMbFlZaqshP-ci_j1kI74AWBT-H");
        myMap.put("absolute_xml", "1poGstp-zyIpX4pmRFkhhdYhmTGl5ttzB");
        myMap.put("table_java", "1PrFiTfSojI9f5F1tjf4BQci5NWfZW6qA");
        myMap.put("table_xml", "1odulAOlkWZw56rMaJDsKFFslPbP9sRJv");
        myMap.put("grid_java", "1mduvX5ugZs2UQOFcvB4iYnqcxSwLHmJt");
        myMap.put("grid_xml", "1NsYu4Iq8701b-Msu4n_f8-eV26YfIRpU");
        myMap.put("frame_java", "1MTG4UO5Mzsvr1pb5V6ruuGz_RrbXobLZ");
        myMap.put("frame_xml", "1Dc9IQbxo_apf8mLt5nKPfT9QihKucXFb");

//        View

        myMap.put("textview_java", "1lrH1P4H7s6Vf_aW9I8Elb_qWT8h3oNLL");
        myMap.put("textview_xml", "10Dqd8YQe4Wa6c0vfi2ESgM1-JMPRkZOc");
        myMap.put("editview_java", "1CT_1ckaDA7pe4B4r8339VEvCyfAqyqz2");
        myMap.put("editview_xml", "1cOgpps9YvtyYGYhddSKy6kjHiMzeq9bK");
        myMap.put("imageview_java", "164S6L-P6wz2x1xX_LsPKDIhYmUkaohZM");
        myMap.put("imageview_xml", "1yMV9H70Ri1YfXm880vzd0RE3-heZhndv");

        final String pdfid = myMap.get(getIntent().getStringExtra("doc_name"));
        String fileUrl = "https://drive.google.com/uc?export=download&id=" + pdfid;
        new LoadTextFromUrl().execute(fileUrl);

        copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) DisplayCode.this.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text Data", code.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(DisplayCode.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });
    }
     class LoadTextFromUrl extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {
            try {
                String url = urls[0];
                URL textUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) textUrl.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                String text = scanner.hasNext() ? scanner.next() : "";
                scanner.close();
                inputStream.close();
                connection.disconnect();
                return text;
            } catch (IOException e) {
                Log.e("CopyTextTask", "Error while copying text", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String text) {
            if (text != null) {
                Button copy = findViewById(R.id.copy);
                ImageView loader= findViewById(R.id.loader);
                loader.setVisibility(View.INVISIBLE);

                TextView code = findViewById(R.id.code);
                copy.setVisibility(View.VISIBLE);
                code.setText(text);
            } else {
                // handle error
            }
        }
    }

}



