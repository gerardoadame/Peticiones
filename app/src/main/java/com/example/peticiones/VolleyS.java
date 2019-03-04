package com.example.peticiones;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class VolleyS {
    private static VolleyS mVolleys=null;
    private RequestQueue mRequestQueue;

    private VolleyS(Context context)
    {

        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyS getInstance(Context context)
    {
        if(mVolleys==null)
        {
            mVolleys = new VolleyS(context);
        }
        return mVolleys;
    }

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }

}
