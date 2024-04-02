package com.example.carinformation;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter myAdapter;


    FragmentManager fragmentManager;

    Fragment buttonsFrag, pictureFrag, listFrag, descriptionFrag;

    View buttonsFragView, descriptionFragView, listFragView, pictureFragView;

    TextView tvName, tvPhoneNumber;

    Button btnCarInfo, btnOwnerInfo;

    ImageView ivCarLogo;

    ArrayList<Car> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fragmentManager.beginTransaction()
                .hide(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.decsriptionFrag)))
                .commit();

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.decsriptionFrag)))
                        .show(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.pictureFrag)))
                        .commit();

            }
        });


        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.pictureFrag)))
                        .show(Objects.requireNonNull(fragmentManager.findFragmentById(R.id.decsriptionFrag)))
                        .commit();

            }
        });

        // have to make this class on your own
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

        });


    }

    private void init () {


        fragmentManager = getSupportFragmentManager();

        buttonsFrag = fragmentManager.findFragmentById(R.id.buttonsFrag);
        descriptionFrag = fragmentManager.findFragmentById(R.id.decsriptionFrag);
        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        pictureFrag = fragmentManager.findFragmentById(R.id.pictureFrag);

        // getting all views of the fragments
        buttonsFragView = Objects.requireNonNull(buttonsFrag).requireView();
        descriptionFragView = Objects.requireNonNull(descriptionFrag).requireView();
        listFragView = Objects.requireNonNull(listFrag).requireView();
        pictureFragView = Objects.requireNonNull(pictureFrag).requireView();

        btnCarInfo = buttonsFragView.findViewById(R.id.btnCarInfo);
        btnOwnerInfo = buttonsFragView.findViewById(R.id.btnOwnerInfo);

        tvName = descriptionFragView.findViewById(R.id.tvName);
        tvPhoneNumber = descriptionFragView.findViewById(R.id.tvPhoneNumber);

        ivCarLogo = pictureFragView.findViewById(R.id.ivCarLogo);


        // populating the list here
        list = new ArrayList<>();
        list.add(new Car(R.drawable.mercedes,"2003","Danish","01234"));
        list.add(new Car(R.drawable.nissan,"2004","Ans","01235"));
        list.add(new Car(R.drawable.volkswagen,"2005","Babar","01236"));


        recyclerView = listFragView.findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

    }

}