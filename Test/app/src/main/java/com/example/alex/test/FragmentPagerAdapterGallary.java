package com.example.alex.test;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Random;


/**
 * Created by Alex on 27.04.2015.
 */
public class FragmentPagerAdapterGallary extends Fragment {
  static   ProgressBar progressBar;

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
    public static String[] URL1 = {"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRhG5rMM3UX8z4JG0PE9JnTPa7iaXOiB6pLE_soQNbwlryt8mdy5A",
         "http://rewalls.com/large/201203/63548.jpg"
        ,"http://www.nastol.com.ua/pic/201208/2560x1440/nastol.com.ua-29508.jpg"
        ,"http://kdlt.ru/wp-content/uploads/2012/09/127.jpg"
        ,"http://www.wallsgeneration.ru/images/original/lamba-[1920x1200]-[2385235].jpg"
        ,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR81wd_ZmOYeFtHCPPQBheBILa7pOWU0VZl3u2gdz7WsVp0Un-w"
        ,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR0TD8VTNwUGR5GpBwqGaPsYeWg4FMibzaO4vrhACKsWYDlgCKhfw"
        ,"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR7kc-mLhgU28WVKduFfAjeVZPmUt1ybUjejT-hv_jkOH0bH3Ld"
        ,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSzeU-InYeIZbDjb8bxz5NzsR3QCcPtHhd9f_jaT2gYImoyYfFA"
        ,"http://f9.ifotki.info/org/71a2543234450c4cd8b01c150cccfcc44e24d797267247.jpg"};
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
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        task.execute(URL1[pageNumber]);
        return view;
    }
}
