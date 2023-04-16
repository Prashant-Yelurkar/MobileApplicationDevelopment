package com.example.mobileapplicationdevelopment.component.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapplicationdevelopment.DisplayCode;
import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;

public class Edit_Text extends AppCompatActivity {

    private Button submit , java ,xml, doc;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edittext);

        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Edit_Text.this,name.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        java = findViewById(R.id.java);
        xml = findViewById(R.id.xml);
        doc = findViewById(R.id.documentation);

        java.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Edit_Text.this, DisplayCode.class);
                i.putExtra("doc_name", "editview_java");
                startActivity(i);
            }
        });
        java.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                Intent i = new Intent(Edit_Text.this, DisplayCode.class);
                i.putExtra("doc_name", "editview_java");
                startActivity(i);
                return true;
            }
        });

        xml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Edit_Text.this, DisplayCode.class);
                i.putExtra("doc_name", "editview_xml");
                startActivity(i);
            }
        });

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Edit_Text.this, DisplayPdf.class);
                i.putExtra("doc_name", "editview");
                startActivity(i);
            }
        });



    }
}