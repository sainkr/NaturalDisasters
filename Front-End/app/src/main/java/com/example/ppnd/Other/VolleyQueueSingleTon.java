package com.example.ppnd.Other;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyQueueSingleTon {
    private static VolleyQueueSingleTon volleyQueueSingleTonInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleyQueueSingleTon(Context getContext){
        context = getContext;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyQueueSingleTon getInstance(Context getContext){
        if(volleyQueueSingleTonInstance == null){
            volleyQueueSingleTonInstance = new VolleyQueueSingleTon(getContext);
        }
        return volleyQueueSingleTonInstance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
