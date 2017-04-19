package com.xwen.friapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class CbsActivity extends AppCompatActivity {

//    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_cbs);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(CbsActivity.this,"Hello,welcome to lauwen's application!",Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "Do you want to add a item ?", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"Do you want to remove a item ?", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
