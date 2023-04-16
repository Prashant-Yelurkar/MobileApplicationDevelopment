package com.example.mobileapplicationdevelopment.component.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mobileapplicationdevelopment.DisplayCode;
import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;

public class Image_View extends AppCompatActivity {
    private Button java, xml, doc;
      int images []= {R.drawable.image_view,R.drawable.logo,R.drawable.landingimg};
      int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Button change = findViewById(R.id.chageImage);
        ImageView image = (ImageView) findViewById(R.id.imageview);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = (num +1) % images.length;;
                image.setImageResource(images[num]);
            }
        });

        java = findViewById(R.id.java);
        xml = findViewById(R.id.xml);
        doc = findViewById(R.id.documentation);

        java.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Image_View.this, DisplayCode.class);
                i.putExtra("doc_name", "imageview_java");
                startActivity(i);
            }
        });
        xml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Image_View.this, DisplayCode.class);
                i.putExtra("doc_name", "imageview_xml");
                startActivity(i);
            }
        });
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name", "imageview");
                startActivity(i);
            }
        });

    }
}