package com.example.mobileapplicationdevelopment.component.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobileapplicationdevelopment.DisplayCode;
import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;

public class Table_Layout extends AppCompatActivity {
    private EditText t1, t2,t3,t4;
    private String name, rollno,enrollnmentno,password;
    private Button submit, cancel;
    private Button xml, java, doc;
    private TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);


        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.rollno);
        t3 = findViewById(R.id.enrollnmentno);
        t4 = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        cancel = findViewById(R.id.cancel);
        details = findViewById(R.id.details);
        submit.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name = t1.getText().toString();
                rollno = t2.getText().toString();
                enrollnmentno = t3.getText().toString();
                password = t4.getText().toString();
                details.setText(("Details : \nName :"+name+"\nRoll No. :"+rollno+"\nEnrollnement No. :"+enrollnmentno+"\nPassword :"+password));
            }
        });
        cancel.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                details.setText("");
            }
        });

        java = findViewById(R.id.java);
        xml = findViewById(R.id.xml);
        doc = findViewById(R.id.documentation);

        java.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Table_Layout.this, DisplayCode.class);
                i.putExtra("doc_name", "table_java");
                startActivity(i);
            }
        });
        xml.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Table_Layout.this, DisplayCode.class);
                i.putExtra("doc_name", "table_xml");
                startActivity(i);
            }
        });
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name", "tableLayout");
                startActivity(i);
            }
        });
    }
}