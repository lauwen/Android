package com.xwen.friapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class friActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fri);
        Button btn_f = (Button) findViewById(R.id.btn_f);
        btn_f.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(friActivity.this,secActivity.class);    //显式intent

//                Intent intent = new Intent("com.example.activitytest.ACTION_START");    //隐式intent
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");  //自定义category

//                Intent intent = new Intent(Intent.ACTION_VIEW);   //浏览器
//                intent.setData(Uri.parse("http://www.baidu.com"));

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:114"));

                startActivity(intent);
            }

        });
    }
}
