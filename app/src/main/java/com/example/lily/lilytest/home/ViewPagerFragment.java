package com.example.lily.lilytest.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lily.lilytest.R;

/**
 * Created by ljq
 * on 2018/3/2.
 */

public class ViewPagerFragment extends Fragment {

   public static ViewPagerFragment newInstance(String sign){
       ViewPagerFragment fragment=new ViewPagerFragment();
       Bundle bundle=new Bundle();
       bundle.putString("sign",sign);
       fragment.setArguments(bundle);
       return fragment;

    }

    String b="test";

    TextView tv_sign;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         if(getArguments()!=null){
             b=getArguments().getString("sign");
         }
        View view =inflater.inflate(R.layout.fragment_viewpager,null);
         tv_sign= (TextView) view.findViewById(R.id.tv_center_sign);
        tv_sign.setText(b);

        return view;
    }
}
