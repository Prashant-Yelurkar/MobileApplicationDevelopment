package com.example.mobileapplicationdevelopment.component.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;

public class ArchitectureDiagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture_diagram);

        Button doc = findViewById(R.id.documentation);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name","architecture");
                startActivity(i);
            }
        });
    }
}