package com.example.administrator.gustoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 8/6/2019.
 */

public class MenuFragment extends Fragment {

    Button btn_btn1;
    Button btn_btn2;
    Button btn_btn3;
    Button btn_btn4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);

        btn_btn1 =(Button) view.findViewById(R.id.FoodDetails_btn1);
        btn_btn2 =(Button) view.findViewById(R.id.FoodDetails_btn2);
        btn_btn3 =(Button) view.findViewById(R.id.FoodDetails_btn3);
        btn_btn4 =(Button) view.findViewById(R.id.FoodDetails_btn4);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btn_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FriedRiceList.class);
                startActivity(intent);
            }
        });

    }
}
