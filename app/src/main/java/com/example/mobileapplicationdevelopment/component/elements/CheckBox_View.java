package com.example.mobileapplicationdevelopment.component.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mobileapplicationdevelopment.DisplayCode;
import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;
import com.example.mobileapplicationdevelopment.component.layouts.Table_Layout;

public class CheckBox_View extends AppCompatActivity {
    Button submit , java, xml, doc;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_view);
        int[] checkboxIds ={R.id.cB,R.id.cB2,R.id.cB3,R.id.cB4};
        submit = findViewById(R.id.submit);
        output = findViewById(R.id.output);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String msg = "Your Interests:\n";
                for (int checkboxId : checkboxIds) {
                    CheckBox checkbox = findViewById(checkboxId);
                    if (checkbox.isChecked()) {
                       msg = msg +  (checkbox.getText().toString()+"\n");
                    }
                }

                output.setText(msg);
            }
        });
        java = findViewById(R.id.java);
        xml = findViewById(R.id.xml);
        doc = findViewById(R.id.documentation);

        java.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(CheckBox_View.this, DisplayCode.class);
                i.putExtra("doc_name", "checkbox_java");
                startActivity(i);
            }
        });
        xml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(CheckBox_View.this, DisplayCode.class);
                i.putExtra("doc_name", "checkbox_xml");
                startActivity(i);
            }
        });
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name", "checkbox");
                startActivity(i);
            }
        });
    }
}