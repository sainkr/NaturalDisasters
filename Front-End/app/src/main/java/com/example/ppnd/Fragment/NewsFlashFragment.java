package com.example.ppnd.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ppnd.Adapter.LocationAdapter;
import com.example.ppnd.Data.LocationData;
import com.example.ppnd.Other.DataParsing;
import com.example.ppnd.Other.LocationCode;
import com.example.ppnd.R;
import com.example.ppnd.SearchLocationActivity;
import com.github.chrisbanes.photoview.PhotoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsFlashFragment extends Fragment {

    private RecyclerView recyclerview = null;
    private LinearLayoutManager layoutManager;
    private LocationAdapter nationwideAdapter = null;
    private ArrayList<LocationData> arrayList;
    private LocationData nationwideData;

    private EditText et_search;
    private Button btn_search;
    private PhotoView photoView_satellite;

    private String current_address = null;
    private int current_code;

    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public static String date;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newsflash, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();

        nationwideAdapter = new LocationAdapter(arrayList);
        recyclerview.setAdapter(nationwideAdapter);

        //NavigationBarMainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        String newsflash_data = bundle.getString("nation_wide_newsflash"); //전국 속보 받아오기 (전국 코드 : 108)
        Bitmap satellite_data = bundle.getParcelable("satellite_image"); //위성사진 받아오기

        String []split_data = newsflash_data.split("\n");
        int size = split_data.length;
        for(int i=0; i<size; i++) {
            nationwideData = new LocationData(split_data[i]);

            arrayList.add(nationwideData); //RecyclerView의 마지막 줄에 삽입
            nationwideAdapter.notifyDataSetChanged();
        }
        photoView_satellite.setImageBitmap(satellite_data); //이미지뷰에 위성사진 띄우기

        //검색 버튼 리스너
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_address = LocationCode.currentAddress(String.valueOf(et_search.getText()));
                current_code = LocationCode.currentLocationCode(current_address);

                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
                intent.putExtra("current_address", current_address);
                intent.putExtra("current_code", current_code);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        et_search = getView().findViewById(R.id.et_search);
        btn_search = getView().findViewById(R.id.btn_search);
        recyclerview = getView().findViewById(R.id.recyclerview_nationwide_location);
        photoView_satellite = getView().findViewById(R.id.photoView_satellite);

        //오늘 날짜 받아오기
        date = format.format(new Date());
    }
}