package com.univcollege.phpapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText firstname,lastname;
    private String strfirstname, strlastname;
    private Button sign_in_register;
    private RequestQueue requestQueue;
    private static final String URL = "http://localhost/androidPHP2/connection.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstname= (EditText) findViewById(R.id.firstname);
        lastname= (EditText) findViewById(R.id.lastname);

        sign_in_register= (Button) findViewById(R.id.registerLogin);
        sign_in_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strfirstname= firstname.getText().toString();
                strlastname= lastname.getText().toString();

                requestQueue= Volley.newRequestQueue(MainActivity.this);
                request= new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), "Connect to internet", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(MainActivity.this, WelcomeActivity.class);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Can't connect to internet "+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                )  {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params= new HashMap<String, String>();
                        params.put("firstname", strfirstname);
                        params.put("lastname", strlastname);
                        return params;
                    }
                };
                requestQueue.add(request);
            }
        });

    }

    public void clickRegisterLogin(View view) {




    }
}
