package com.example.tt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tt.Adapter.RecyclerProductAdapter;
import com.example.tt.R;
import com.example.tt.fragment.CatalogueFragment;
import com.example.tt.fragment.HomeFragment;
import com.example.tt.fragment.NoticeFragment;
import com.example.tt.fragment.PersonFragment;
import com.example.tt.fragment.SearchFragment;
import com.example.tt.model.DataItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerProductAdapter.ItemClickListener {
    ImageButton button;
    private ArrayList<DataItem> listData = new ArrayList();
    DataItem dataItem1, dataItem2, dataItem3,dataItem4;
    private BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    RecyclerProductAdapter adapter = new RecyclerProductAdapter(listData,this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        initUI();
        addVent();
        initView();

       bottomNavigationView=findViewById(R.id.bottomNav);
       bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
       getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment=null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.Home:
                        fragment= new HomeFragment();
                        break;
                        case R.id.Catalogue:
                            fragment= new CatalogueFragment();
                            break;
                        case R.id.search:
                            fragment= new SearchFragment();
                            break;
                        case R.id.Notice:
                            fragment= new NoticeFragment();
                            break;
                        case R.id.Person:
                            fragment= new PersonFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return true;
              }
           };

    private void addVent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BookActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initUI(){
        button = findViewById(R.id.btnbook);


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView = (RecyclerView) findViewById(R.id.flash_deal);
        recyclerView.setLayoutManager(layoutManager);
        dataItem1 = new DataItem(getResources().getIdentifier("horse","drawable", getPackageName()),getResources().getString(R.string.horse));
        dataItem2 = new DataItem(getResources().getIdentifier("cow","drawable", getPackageName()),getResources().getString(R.string.cow));
        dataItem3 = new DataItem(getResources().getIdentifier("camel","drawable", getPackageName()),getResources().getString(R.string.camel));
        dataItem4 = new DataItem(getResources().getIdentifier("horse","drawable", getPackageName()),getResources().getString(R.string.horse));
        listData.add(dataItem1);
        listData.add(dataItem2);
        listData.add(dataItem3);
        listData.add(dataItem4);

        adapter = new RecyclerProductAdapter(listData, this,this);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    private void initVariable() {


    }

    public void initView(){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setLayoutManager(gridLayoutManager);
        dataItem1 = new DataItem(getResources().getIdentifier("horse","drawable", getPackageName()),getResources().getString(R.string.horse));
        dataItem2 = new DataItem(getResources().getIdentifier("cow","drawable", getPackageName()),getResources().getString(R.string.cow));
        dataItem3 = new DataItem(getResources().getIdentifier("camel","drawable", getPackageName()),getResources().getString(R.string.camel));
        dataItem4 = new DataItem(getResources().getIdentifier("horse","drawable", getPackageName()),getResources().getString(R.string.horse));
        listData.add(dataItem1);
        listData.add(dataItem2);
        listData.add(dataItem3);
        listData.add(dataItem4);

        adapter = new RecyclerProductAdapter(listData,this, this);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {

    }
}
