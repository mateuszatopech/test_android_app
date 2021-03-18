package com.example.newsapiapplication;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {


    Button button;
    EditText editTextFrase;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String API_KEY = "d5993f47ac3a4bdabcae2b573f29a2fc";
    String phrase = "elections";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RequestQueue queue = Volley.newRequestQueue(this);


        ListView list = (ListView) findViewById(R.id.listView1);
        button = (Button) findViewById((R.id.button));
        editTextFrase = (EditText) findViewById(R.id.editTextFrase);
        String url = ("https://newsapi.org/v2/everything?q=" + phrase + "&from=2021-03-15&sortBy=popularity&apiKey=" + API_KEY);
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<>();

        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> {
//                    String stringFromResponse = (String) response;
//                    int j = 0;
//                    int lengthOfString = stringFromResponse.length();
//
//
//                    if(lengthOfString != 0)
//                    {
//                        for (int i = 0; i < lengthOfString; i++) {
//                            if (stringFromResponse.contains("title")) {
//                                titles.add(stringFromResponse.substring(stringFromResponse.indexOf("title") + 7, stringFromResponse.indexOf("description") - 3));
//                                urls.add(stringFromResponse.substring(stringFromResponse.indexOf("url") + 6, stringFromResponse.indexOf("urlToImage") - 3));
//
//                                stringFromResponse = stringFromResponse.substring(stringFromResponse.indexOf("content") + 10, lengthOfString - 1);
//                                lengthOfString = stringFromResponse.length();
//
//                                i = 0;
//                                j++;
////                                Toast.makeText(getApplicationContext(),
////                                        "Number of iteration:" + j, Toast.LENGTH_LONG)
////                                        .show();
//
//                                if(j>=20){
//                                    break;
//                                }
//                            }
//
//                        }
//                    }
//                }, error -> Toast.makeText(getApplicationContext(),
//                "That didn't work!", Toast.LENGTH_LONG)
//                .show()){
//            @Override
//            public Map<String, String> getHeaders(){
//                Map<String, String> headers = new HashMap<String, String>();
//                headers.put("User-agent", "Mozilla/5.0");
//                return headers;
//            }
//        };

// Add the request to the RequestQueue.
//        queue.add(stringRequest);



        ArrayList<String> carL = new ArrayList<>();
        carL.addAll( titles );
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.element_view, carL);

        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls.get(position)));
            startActivity(browserIntent);
        });

        button.setOnClickListener(v -> {
            phrase = editTextFrase.getText().toString();
            titles.clear();
            urls.clear();
//            ArrayList<String> titles = new ArrayList<>();
//            ArrayList<String> urls = new ArrayList<>();
//            int[][] titlesIndex = new int[2000][2] , urlsIndex = new int[2000][2];
               String url1 = ("https://newsapi.org/v2/everything?q=" + phrase + "&from=2021-03-15&sortBy=popularity&apiKey=" + API_KEY);

//            final JsonArrayRequest jsonObjReq1 = new
//                    JsonArrayRequest(Request.Method.GET, url, null,
//                            new Response.Listener<JSONArray>() {
//
//                                @Override
//                                public void onResponse(JSONArray response) {
//                                    Log.d(TAG, response.toString());
//                                    Toast.makeText(getApplicationContext(),
//                                            response.toString(), Toast.LENGTH_LONG)
//                                            .show();
//
//                                    try {
//                                        JSONArray jsonArray = new JSONArray(response);
//
//                                        for(int i = 0; i < response.length(); i++){
//                                            JSONObject jresponse = response.getJSONObject(i);
//                                            String nickname = jresponse.getString(TAG);
//                                            Log.d(TAG, nickname);
//                                        }
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//                                    //pDialog.dismiss();
//                                }
//                            }, new com.android.volley.Response.ErrorListener() {
//
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            VolleyLog.d(TAG, "Error: " + error.getMessage());
//                            //pDialog.dismiss();
//
//                        }
//                    }) {
//
//                        @Override
//                        public String getBodyContentType() {
//                            return "application/json; charset=utf-8";
//                        }
//                        @Override
//                        public Map<String, String> getHeaders(){
//                            Map<String, String> headers = new HashMap<String, String>();
//                            headers.put("User-agent", "Mozilla/5.0");
//                            return headers;
//
//                    }
//            };
                    StringRequest stringRequestOnClick = new StringRequest(Request.Method.GET, url1,
                    response -> {
//                         Display the first 500 characters of the response string.
//                        Toast.makeText(getApplicationContext(),
//                                response.substring(0, 1500), Toast.LENGTH_LONG)
//                                .show();
                        //-------------debug------------------------
                        String stringFromResponse = (String) response;
//                        int j=0;
//                        for (int i = -1; (i = stringFromResponse.indexOf("title", i + 1)) != -1; i++) {
//                            titlesIndex[j][0] = i + 7;
//                            j++;
//                        }
//                        j = 0;
//                        for (int i = -1; (i = stringFromResponse.indexOf("description", i + 1)) != -1; i++) {
//                            titlesIndex[j][1] = i - 4;
//                            j++;
//                        }
//                        j = 0;
//                        for (int i = -1; (i = stringFromResponse.indexOf("url", i + 1)) != -1; i++) {
//                            urlsIndex[j][0] = i + 5;
//                            j++;
//                        }
//                        j = 0;
//                        for (int i = -1; (i = stringFromResponse.indexOf("urlToImage", i + 1)) != -1; i++) {
//                            urlsIndex[j][1] = i - 4;
//                            j++;
//                        }
//                        j = 0;
                        int j = 0;
                        int lengthOfString = stringFromResponse.length();
//                        String ToastMsg =  String.valueOf(stringFromResponse.indexOf("title"));
//                        String StringLengthToast =  String.valueOf(lengthOfString);
//                        Toast.makeText(getApplicationContext(),
//                                ToastMsg, Toast.LENGTH_LONG)
//                                .show();
//                        Toast.makeText(getApplicationContext(),
//                                StringLengthToast, Toast.LENGTH_LONG)
//                                .show();


                        if(lengthOfString != 0)
                        {
                            for (int i = 0; i < lengthOfString; i++) {
                                if (stringFromResponse.contains("title")) {
                                    titles.add(stringFromResponse.substring(stringFromResponse.indexOf("title") + 7, stringFromResponse.indexOf("description") - 2));
                                    urls.add(stringFromResponse.substring(stringFromResponse.indexOf("url") + 6, stringFromResponse.indexOf("urlToImage") - 3));

                                    stringFromResponse = stringFromResponse.substring(stringFromResponse.indexOf("content") + 10, lengthOfString - 1);
                                    lengthOfString = stringFromResponse.length();

                                    i = 0;
                                    j++;
//                                    Toast.makeText(getApplicationContext(),
//                                            "Number of iteration:" + j, Toast.LENGTH_LONG)
//                                            .show();
                                    if(j>=12){
                                        break;
                                    }
                                }

                            }
                            carL.clear();
                            carL.addAll( titles );
                            list.setAdapter(adapter);
                        }


//                        try {
//                            JSONObject jsonObj = new JSONObject(stringFromResponse);
//                            Log.d("My App", jsonObj.toString());
//                            JSONObject jsonArrayName =  jsonObj.getJSONObject("title");
////                            JSONArray jsonArrayUrl = jsonObj.getJSONArray("url");
//                            carL.replaceAll((UnaryOperator<String>) jsonArrayName);
//                            list.setAdapter(adapter);
//                            list.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(getApplicationContext(),
//                                    "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                                    .show());
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }, error -> Toast.makeText(getApplicationContext(),
                    "That didn't work!", Toast.LENGTH_LONG)
                    .show()){
                @Override
                public Map<String, String> getHeaders(){
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("User-agent", "Mozilla/5.0");
                    return headers;
                }
            };

// Add the request to the RequestQueue.
            queue.add(stringRequestOnClick);
            
        });
    }
}
