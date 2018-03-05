package com.example.lily.lilytest.home;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;


/**
 * Created by ljq
 * on 2018/3/2.
 */

public class BottomShiftHelper {
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView navigationView){

        BottomNavigationMenuView menuView= (BottomNavigationMenuView) navigationView.getChildAt(0);
        try{
            Field shiftingMode=menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);
            for(int i=0;i<menuView.getChildCount();i++){
                BottomNavigationItemView item= (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }

        }catch (Exception e){

        }

    }
}
