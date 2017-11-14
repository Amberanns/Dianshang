package com.bawei.dianshang.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.dianshang.R;
/**
 * Created by xue on 2017-11-09.
 */

public class Mine extends Fragment{


    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_mine, container, false);
        img = (ImageView) view.findViewById(R.id.img);
 img.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent = new Intent(getActivity(), Fragment_My.class);

         startActivity(intent);
     }
 });
        return view;
    }



}
