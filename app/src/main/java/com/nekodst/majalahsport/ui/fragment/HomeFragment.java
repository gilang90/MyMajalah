package com.nekodst.majalahsport.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.DataMajalah;
import com.nekodst.majalahsport.ui.adapter.MajalahAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    MajalahAdapter majalahAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_items);

        initRecyclerView();
        showListAdapter();

        return view;
    }

    private void showListAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(majalahAdapter);
    }

    private void showGridAdapter() {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(majalahAdapter);
    }

    private void initRecyclerView() {
        majalahAdapter = new MajalahAdapter(getContext());
        majalahAdapter.setMajalahs(DataMajalah.getListMajalah());
        recyclerView.setHasFixedSize(true);
    }

}
