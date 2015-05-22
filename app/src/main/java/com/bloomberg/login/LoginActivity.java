package com.bloomberg.login;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ajendrasharma on 22/02/15.
 */
public class LoginActivity extends Activity {

    Button login ;
    String name , pass ;
    EditText NAME ,PASS;
    Context ctx = this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.button);
        NAME=(EditText)findViewById(R.id.editText);
        PASS=(EditText)findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Please wait...",Toast.LENGTH_SHORT).show();
                name = NAME.getText().toString();
                pass = PASS.getText().toString();
                DatabaseOperations DOP = new DatabaseOperations(ctx);
                Cursor cr = DOP.getInformation(DOP);
                cr.moveToFirst();
                boolean loginstatus = false ;

                do
                {
                    if (name.equals(cr.getString(0))&&pass.equals(cr.getString(1)))
                    {
                        loginstatus = true;


                    }


                }while(cr.moveToNext());

                if(loginstatus)
                {
                    Toast.makeText(getBaseContext(),"Login Success", Toast.LENGTH_LONG).show();

                }


            }
        });


    }






}
