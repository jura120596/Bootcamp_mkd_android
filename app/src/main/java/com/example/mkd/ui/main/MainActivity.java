package com.example.mkd.ui.main;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.example.mkd.R;
import com.example.mkd.Storage;
import com.example.mkd.SwipeHelper;
import com.example.mkd.data.adapter.MkdAdapter;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.retrofit.MkdRetrofit;
import com.example.mkd.ui.fragment.ChangeMkdFragment;
import com.example.mkd.ui.fragment.ChnageCommFragment;
import com.example.mkd.ui.fragment.ChnageRepairFragment;
import com.example.mkd.ui.login.LoginActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String MSG_NAME = "bookFromListByPos";
    public static final int REQUEST_CODE = 1;

    private AppCompatButton btnAdd;

    private FragmentTransaction transaction;

    private MkdAdapter mkdAdapter;

    private RecyclerView rvMkd;


    public static final MkdRetrofit mkdApi = new MkdRetrofit();

    @Override
    protected void onResume() {
        super.onResume();
        if (Storage.user != null) {
            mkdApi.fillMkd(this);
        } else {
            Storage.MKD_LIST.clear();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Storage.user == null) {
            startActivityForResult(new Intent(this, LoginActivity.class), REQUEST_CODE);
        }
        rvMkd = findViewById(R.id.rv_books);
        btnAdd = findViewById(R.id.btn_add);
        mkdAdapter = new MkdAdapter(this, Storage.MKD_LIST);
        rvMkd.setAdapter(mkdAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditFragment(new ObjectMkd());
            }
        });
        SwipeHelper swh = new SwipeHelper(this, rvMkd) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Ремонт",
                        0,
                        Color.parseColor("#FF9502"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                openEditRepair(mkdAdapter.getItem(pos));
                            }
                        }
                ));
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Сети",
                        0,
                        Color.parseColor("#C7C7CB"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                openEditCommunication(mkdAdapter.getItem(pos));
                            }
                        }
                ));
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swh);
        itemTouchHelper.attachToRecyclerView(rvMkd);
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        int size = fragments.size();
        if (size > 0)
            getSupportFragmentManager().beginTransaction().remove(fragments.get(size - 1)).commit();
        else
            finish();
    }

    public void update() {
        mkdAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case REQUEST_CODE: {
                mkdApi.fillMkd(this);
                break;
            }
            default: {

                finish();
            }
        }
    }
    public void openEditFragment(ObjectMkd mkd) {
        transaction = getSupportFragmentManager().beginTransaction();
        ChangeMkdFragment changeFragment = new ChangeMkdFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.MSG_NAME, mkd == null ? new ObjectMkd() : mkd);
        changeFragment.setArguments(bundle);
        transaction.add(R.id.fl_main, changeFragment);
        transaction.commit();
    }
    public void openEditCommunication(ObjectMkd mkd) {
        transaction = getSupportFragmentManager().beginTransaction();
        ChnageCommFragment changeFragment = new ChnageCommFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.MSG_NAME, mkd == null ? new ObjectMkd() : mkd);
        changeFragment.setArguments(bundle);
        transaction.add(R.id.fl_main, changeFragment);
        transaction.commit();
    }
    public void openEditRepair(ObjectMkd mkd) {
        transaction = getSupportFragmentManager().beginTransaction();
        ChnageRepairFragment changeFragment = new ChnageRepairFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.MSG_NAME, mkd == null ? new ObjectMkd() : mkd);
        changeFragment.setArguments(bundle);
        transaction.add(R.id.fl_main, changeFragment);
        transaction.commit();
    }
}