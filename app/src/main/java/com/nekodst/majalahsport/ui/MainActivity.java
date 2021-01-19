package com.nekodst.majalahsport.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.DataMajalah;
import com.nekodst.majalahsport.ui.adapter.MajalahAdapter;
import com.nekodst.majalahsport.ui.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    DataMajalah dataMajalah = new DataMajalah();
    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);
        initView();

//        initRecyclerView();
        initViewPager();
        // ATTENTION: This was auto-generated to handle app links.

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.switchicon:
                /*if (!isGrid) {
                    showGridRecyclerView();
                    item.setIcon(R.drawable.ic_action_list);
                }
                else {
                    showListRecyclerView();
                    item.setIcon(R.drawable.ic_action_grid);
                }
                break;*/

                Toast.makeText(getApplicationContext(), "Harusnya switch "+item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(R.layout.layout_about);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
//
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addTab(tabLayout.newTab().setText(R.string.all_megazines));
        tabLayout.addTab(tabLayout.newTab().setText("Favorite"));
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
    }


}
