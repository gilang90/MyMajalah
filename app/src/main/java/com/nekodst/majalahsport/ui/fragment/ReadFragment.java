package com.nekodst.majalahsport.ui.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.nekodst.majalahsport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {

    private PDFView pdfView;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public ReadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_read, container, false);

        pdfView = view.findViewById(R.id.pdfView);
        String uri = "http://www.marxists.org/reference/archive/einstein/works/1910s/relative/relativity.pdf";
        Uri parsedUri = Uri.parse(uri);

        OnErrorListener onerror = new OnErrorListener() {
            @Override
            public void onError(Throwable t) {
                Toast.makeText(getContext(), "Error: "+t, Toast.LENGTH_SHORT).show();
            }
        };
        pdfView.fromAsset(id+".pdf")
                .swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true)
                .defaultPage(0)
                .onError(onerror)
                .load();

        return view;
    }

}
