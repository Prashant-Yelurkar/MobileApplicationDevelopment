package com.example.mobileapplicationdevelopment.component.layouts;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;

public class All_Layout extends AppCompatActivity {
    ImageButton linear_layout, relative_layout, absolute_layout, table_layout, frame_layout, grid_layout;
    Button doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_layouts);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        linear_layout = findViewById(R.id.linear_layout);
        relative_layout = findViewById(R.id.relative_layout);
        absolute_layout = findViewById(R.id.absolute_layout);
        table_layout = findViewById(R.id.table_layout);
        frame_layout = findViewById(R.id.frame_layout);
        grid_layout = findViewById(R.id.grid_layout);
        doc = findViewById(R.id.documentation);


        Intent intent;

        linear_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this,Linear_Layout.class);
                startActivity(intent);
            }
        });

        relative_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this,Relative_Layout.class);
                startActivity(intent);
            }
        });
        absolute_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this, Absolute_Layout.class);
                startActivity(intent);
            }
        });
        table_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this, Table_Layout.class);
                startActivity(intent);
            }
        });
        grid_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this, Grid_Layout.class);
                startActivity(intent);
            }
        });
        frame_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(All_Layout.this, Frame_Layout.class);
                startActivity(intent);
            }
        });



        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name","Layouts");

                startActivity(i);
            }
        });
    }
}