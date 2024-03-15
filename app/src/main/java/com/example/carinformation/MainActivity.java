package com.example.carinformation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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

public class MainActivity extends AppCompatActivity implements ListFrag.ListClicked{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter myAdapter;


    FragmentManager fragmentManager;

    View buttonsFrag, descriptionFrag, listFrag, pictureFrag;

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

    }

    private void init () {


        fragmentManager = getSupportFragmentManager();

        // getting all views of the fragments
        buttonsFrag = Objects.requireNonNull(fragmentManager.findFragmentById(R.id.buttonsFrag)).requireView();
        descriptionFrag = Objects.requireNonNull(fragmentManager.findFragmentById(R.id.decsriptionFrag)).requireView();
        listFrag = Objects.requireNonNull(fragmentManager.findFragmentById(R.id.listFrag)).requireView();
        pictureFrag = Objects.requireNonNull(fragmentManager.findFragmentById(R.id.pictureFrag)).requireView();

        btnCarInfo = buttonsFrag.findViewById(R.id.btnCarInfo);
        btnOwnerInfo = buttonsFrag.findViewById(R.id.btnOwnerInfo);

        tvName = descriptionFrag.findViewById(R.id.tvName);
        tvPhoneNumber = descriptionFrag.findViewById(R.id.tvPhoneNumber);

        ivCarLogo = pictureFrag.findViewById(R.id.ivCarLogo);


        // populating the list here
        list = new ArrayList<>();
        list.add(new Car(R.drawable.mercedes,"2003","Danish","01234"));
        list.add(new Car(R.drawable.nissan,"2004","Ans","01235"));
        list.add(new Car(R.drawable.volkswagen,"2005","Babar","01236"));


        recyclerView = listFrag.findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

    }



    @Override
    public void onItemClicked(int index) {

        tvName.setText(list.get(index).ownerName);
        tvPhoneNumber.setText(list.get(index).phoneNumber);

        ivCarLogo.setImageResource(list.get(index).logo);

    }
}