package com.example.peticiones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String URL="http://nuevo.rnrsiilge-org.mx/principal";
    TextView lblnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnrecibir).setOnClickListener(this);
        lblnombre=findViewById(R.id.txtnombre);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnrecibir:
                JsonObjectRequest jor =new JsonObjectRequest(
                        Request.Method.GET,
                        URL,
                        null,
                        new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try
                        {
                            lblnombre.setText(response.getString("Nombre"));
                        }catch(JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                }, new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                VolleyS.getInstance(this).getmRequestQueue().add(jor);
                break;
        }

    }
}
