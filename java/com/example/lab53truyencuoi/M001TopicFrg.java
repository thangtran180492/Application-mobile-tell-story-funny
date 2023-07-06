package com.example.lab53truyencuoi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class M001TopicFrg extends Fragment implements View.OnClickListener {
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_m001_topic_frg, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        LinearLayout lnMain = v.findViewById(R.id.ln_topic);
        lnMain.removeAllViews();
        try {
            //Lấy danh sách ảnh trong thư mục …main/assets/photo/
            String[] listItem = mContext.getAssets().list("photo");
            for (String fileName : listItem) {
                String name = fileName.substring(0, fileName.indexOf("."));
                View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);
                ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
                TextView tvTopic = vTopic.findViewById(R.id.tv_topic);
                ivTopic.setImageBitmap(BitmapFactory
                        .decodeStream(mContext.getAssets().open("photo/" + fileName)));
                tvTopic.setText(name);
                lnMain.addView(vTopic);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
                params.bottomMargin = 40;
                vTopic.setLayoutParams(params);
                vTopic.setTag(name);
                vTopic.setOnClickListener(this);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).gotoM002Screen((String)v.getTag());
    }
}