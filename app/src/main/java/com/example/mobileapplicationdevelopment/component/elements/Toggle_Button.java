package com.example.mobileapplicationdevelopment.component.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.mobileapplicationdevelopment.DisplayCode;
import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;
import com.example.mobileapplicationdevelopment.component.layouts.Linear_Layout;

public class Toggle_Button extends AppCompatActivity {
    ToggleButton tg;
    ImageView img;
    Button java, xml, doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        tg=(ToggleButton)findViewById(R.id.chageImage);
        img=(ImageView)findViewById(R.id.imageview);

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   img.setImageResource(R.drawable.bulbon);
                } else {
                    img.setImageResource(R.drawable.bulboff);
                }
            }
        });

        java = findViewById(R.id.java);
        xml = findViewById(R.id.xml);
        doc = findViewById(R.id.documentation);

        java.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Toggle_Button.this, DisplayCode.class);
                i.putExtra("doc_name", "togglebutton_java");
                startActivity(i);
            }
        });
        xml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Toggle_Button.this, DisplayCode.class);
                i.putExtra("doc_name", "togglebutton_xml");
                startActivity(i);
            }
        });
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name", "togglebutton");
                startActivity(i);
            }
        });

    }
}