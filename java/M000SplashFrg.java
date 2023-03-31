package com.example.lab53truyencuoi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link M000SplashFrg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class M000SplashFrg extends Fragment {

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initViews();

        return inflater.inflate(R.layout.fragment_m000_splash_frg, container, false);

    }

    private void initViews() {

        new Handler().postDelayed(this::gotoM001Screen, 2000);

    }

    private void gotoM001Screen() {

        ((MainActivity) getActivity()).gotoM001Screen();

    }
}