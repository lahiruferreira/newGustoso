package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

//       SQLiteOpenHelper openHelper;
  //     SQLiteDatabase db;
    //   EditText txtUname,txtPass;
      // Cursor cursor;

        private Button btn1;

        private Button btn2;
        private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //openHelper = new GustosoDBHelper(this);
        //db = openHelper.getReadableDatabase();

       btn1 = (Button) findViewById(R.id.btnlogin);
       //txtUname = (EditText) findViewById(R.id.txtuser);
       //txtPass = (EditText) findViewById(R.id.txtpwd);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* String uname = txtUname.getText().toString();
                String password = txtPass.getText().toString();
                cursor = db.rawQuery(" SELECT * FROM " + GustosoDBHelper.REG_TABLE + " WHERE " + GustosoDBHelper.COLOUMN_7 + "= ? AND " + GustosoDBHelper.COLOUMN_8 + "=? " , new String[]{uname, password} );
                if (cursor!=null){
                    if (cursor.getCount()>0){
                       cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), " login successfully",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }

                */

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

       btn2 = (Button) findViewById(R.id.btnsignup);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, signup.class);
                startActivity(intent);
            }
        });

        btn3 = (Button) findViewById(R.id.btnadmin);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, admin_dashboard.class);
                startActivity(intent);
            }
        });




    }
}
