package com.bloomberg.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {
  EditText USER_NAME,USER_PASS,CON_PASS;
    String user_name,user_pass,con_pass;
   Button REG;
    Context ctx = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        USER_NAME= (EditText) findViewById(R.id.reg_user);
        USER_PASS= (EditText) findViewById(R.id.reg_pas);
        CON_PASS= (EditText) findViewById(R.id.con_pas);
        REG = (Button) findViewById(R.id.user_reg);
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();

                if(!(user_pass.equals(con_pass)))
                {
                    Toast.makeText(getBaseContext(), "Passwords not matching.",Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    CON_PASS.setText("");
                }
                else
                {
                    DatabaseOperations DB= new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(),"Registration success",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
