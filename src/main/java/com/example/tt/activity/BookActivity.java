package com.example.tt.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tt.Adapter.BookAdapter;
import com.example.tt.R;
import com.example.tt.model.Book;
import com.example.tt.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    Toolbar toolbarsach;
    ListView lvsach;
    BookAdapter bookAdapter;
    ArrayList<Book> mangbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarbook);
        mToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        anhxa();
        Getdatabook();
    }

    private void Getdatabook() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanbook, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response !=null){
                    int id = 0;
                    String tensanpham = "";
                    int giasanpham = 0;
                    String hinhanhsanpham = "";
                    for (int i = 0 ; i< response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tensanpham = jsonObject.getString("tensanpham");
                            giasanpham = jsonObject.getInt("giasanpham");
                            hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                            mangbook.add(new Book(id,tensanpham,giasanpham,hinhanhsanpham));
                            bookAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void anhxa() {
        toolbarsach = findViewById(R.id.toolbarbook);
        lvsach = findViewById(R.id.lvbook);
        mangbook = new ArrayList<>();
        bookAdapter = new BookAdapter(getApplicationContext(),mangbook);
        lvsach.setAdapter(bookAdapter);
    }
}