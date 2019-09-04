package com.example.administrator.gustoso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/6/2019.
 */

public class CustreviewFragment extends Fragment {

    GustosoDBHelper gustosoDBHelper;
    ArrayList<String> listReview;
    ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_showreview,container,false);


    }
}
