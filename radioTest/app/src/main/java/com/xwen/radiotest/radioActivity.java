package com.xwen.radiotest;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class radioActivity extends AppCompatActivity {
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup rr = null;
    Button sure1 = null;
    Button exit1 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        rr = (RadioGroup) findViewById(R.id.aa);

        r1 =(RadioButton) findViewById(R.id.a);
        r2 =(RadioButton) findViewById(R.id.b);
        r3 =(RadioButton) findViewById(R.id.c);
        r4 =(RadioButton) findViewById(R.id.d);
        r1.setClickable(true);

        sure1 =(Button) findViewById(R.id.sure);
        exit1 =(Button) findViewById(R.id.exit);
        sure1.setOnClickListener(new sure1());
        exit1.setOnClickListener(new exit1());
    }
    class sure1 implements OnClickListener{
        @Override
        public void onClick(View v){

        }
    }
}
