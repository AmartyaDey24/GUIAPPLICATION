package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_1.R;

public class MainActivity extends AppCompatActivity {
    String name,dept,spin_val;
    String [] gender={"Male", "Female"};
    float prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e=(EditText)findViewById(R.id.editText2);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton r1=(RadioButton)findViewById(R.id.radioButton5);
        final RadioButton r2=(RadioButton)findViewById(R.id.radioButton6);
        final Spinner s=(Spinner)findViewById(R.id.spinner2);
        RatingBar rb=(RatingBar)findViewById(R.id.ratingBar2);
        Button b=(Button)findViewById(R.id.button2);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin_val=gender[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, gender);

// setting adapters to spinners

        s.setAdapter(spin_adapter);
        rg.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int arg1) {
// TODO Auto-generated method stub
                        if(r1.isChecked()==true)
                            dept="B.Tech CSE";
                        if(r2.isChecked()==true)
                            dept="B.Tech IT";
                    }
                });
        rb.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener()
                {
                    @Override
                    public void onRatingChanged(RatingBar arg0, float arg1,
                                                boolean arg2) {
// TODO Auto-generated method stub
                        prog=arg1;
                    }
                });
        b.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View arg0) {
                        name=e.getText().toString();
                        //gender=s.getSelectedItem().toString();
                        Toast.makeText(getApplicationContext(),"Name:"+name+"\n Gender : "+spin_val+"\n Degree : "+dept+"\n Programming Knowledge : "+prog,
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}