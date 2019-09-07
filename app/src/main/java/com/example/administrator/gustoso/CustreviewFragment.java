package com.example.administrator.gustoso;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/6/2019.
 */

public class CustreviewFragment extends Fragment {

    GustosoDBHelper gustosoDBHelper;
    ArrayList<String> listReview;
    ArrayAdapter adapter;
    ListView reviewList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_showreview, container, false);

       // listReview = new ArrayList<>();
       // reviewList = v.findViewById(R.id.reviewList);
      // viewData();

       /* reviewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Text = reviewList.getItemAtPosition(0).toString();
                Toast.makeText(getActivity(), "" + Text, Toast.LENGTH_SHORT).show();
            }
        });*/
        return v;

    }

    //Me code eke waraddak tiyeno///
    ////////////////////////////
    /*private void viewData() {
        Cursor cursor = gustosoDBHelper.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listReview.add(cursor.getString(0));
            }
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listReview);
            reviewList.setAdapter(adapter);
        }
    }*/
}


