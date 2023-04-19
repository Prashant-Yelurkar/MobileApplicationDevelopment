package com.example.mobileapplicationdevelopment.component.elements;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mobileapplicationdevelopment.DisplayPdf;
import com.example.mobileapplicationdevelopment.R;
public class All_Element extends AppCompatActivity {

    ImageButton textview, editview, imageview, imagebutton ,button_view, toggle_button,checkbox_view, datepicker;
    Intent intent;
    Button documentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_element);

        textview = findViewById(R.id.textview);
        editview = findViewById(R.id.editview);
        imageview = findViewById(R.id.imageview);
        imagebutton = findViewById(R.id.imagebutton);
        button_view = findViewById(R.id.button_view);
        toggle_button =  findViewById(R.id.toggle_button);
        checkbox_view =  findViewById(R.id.checkbox_view);
        datepicker = findViewById(R.id.datepicker);
        documentation = findViewById(R.id.documentation);


        textview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this, Text_View.class);
                startActivity(intent);
            }
        });
        editview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this, Edit_Text.class);
                startActivity(intent);
            }
        });
        imageview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,Image_View.class);
                startActivity(intent);
            }
        });
        imagebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,Image_Button.class);
                startActivity(intent);
            }
        });
        button_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,Button_view.class);
                startActivity(intent);
            }
        });
        toggle_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,Toggle_Button.class);
                startActivity(intent);
            }
        });

        checkbox_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,CheckBox_View.class);
                startActivity(intent);
            }
        });

        datepicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                intent = new Intent(All_Element.this,Date_Picker.class);
                startActivity(intent);
            }
        });


        documentation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayPdf.class);
                i.putExtra("doc_name","allViews");

                startActivity(i);
            }
        });
    }
}