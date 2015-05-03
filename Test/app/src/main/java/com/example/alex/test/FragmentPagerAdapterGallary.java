package com.example.alex.test;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Random;


/**
 * Created by Alex on 27.04.2015.
 */
public class FragmentPagerAdapterGallary extends Fragment {

    static final String  ARGUMENT_PAGE_NUMBER = "arg_page_number";
    int pageNumber;
    int backColor;
    public static ImageView image;
    int[] mRes = {
            R.drawable.sub1,
            R.drawable.sub2,
            R.drawable.sub3,
            R.drawable.sub4,
            R.drawable.sub5,
            R.drawable.sub6,
            R.drawable.sub7,
            R.drawable.sub8,
            R.drawable.sub9,
            R.drawable.sub10,
    };
    public static String URL1 = "http://theopentutorials.com/totwp331/wp-content/uploads/totlogo.png";
    GetXMLTask task = new GetXMLTask();


    static FragmentPagerAdapterGallary newInstance(int page) {
        FragmentPagerAdapterGallary fragmentPagerAdapterGallary = new FragmentPagerAdapterGallary();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER,page);
        fragmentPagerAdapterGallary.setArguments(arguments);
        return fragmentPagerAdapterGallary;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd  = new Random();
        backColor = Color.argb(40,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pageradaptergallery,null);
        image = (ImageView) view.findViewById(R.id.imageView);
        task.execute(URL1);
        return view;
    }
}
