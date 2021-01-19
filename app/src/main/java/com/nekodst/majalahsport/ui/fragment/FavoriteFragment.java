package com.nekodst.majalahsport.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.DataMajalah;
import com.nekodst.majalahsport.model.Majalah;
import com.nekodst.majalahsport.ui.adapter.MajalahAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    RecyclerView recyclerView;
    MajalahAdapter majalahAdapter;
    List<Majalah> majalahs = new ArrayList<>();

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = view.findViewById(R.id.rv_items);

        initRecyclerView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }

    private void initRecyclerView() {
        majalahs.clear();
        for (int a = 0; a < DataMajalah.getListMajalah().size(); a++){
            if (DataMajalah.getListMajalah().get(a).getIsFavorite().equals("1")) majalahs.add(DataMajalah.getListMajalah().get(a));
        }

        majalahAdapter = new MajalahAdapter(getContext());
        majalahAdapter.setMajalahs(majalahs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(majalahAdapter);
        majalahAdapter.notifyDataSetChanged();
    }

}
