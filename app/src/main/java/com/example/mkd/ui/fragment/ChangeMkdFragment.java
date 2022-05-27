package com.example.mkd.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.example.mkd.R;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.ui.main.MainActivity;


public class ChangeMkdFragment extends Fragment {

    private EditText etAddress;
    private AppCompatSpinner sp_author;
    private AppCompatSpinner sp_genre;

    private boolean checkEmpty() {
        boolean problem = false;

        if (TextUtils.isEmpty(etAddress.getText().toString())) {
            etAddress.setError("Обязательное поле");
            problem = true;
        }

        return problem;
    }
    public void setTVText(View view, int id, String text) {
        ((TextView)view.findViewById(id)).setText(text);
    }
    public float getTvFloat(View view, int id) {
        return Float.parseFloat(((EditText)view.findViewById(id)).getText().toString());
    }
    public String getTvText(View view, int id) {
        return (((EditText)(view.findViewById(id))).getText().toString());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_change_book, container, false);

        etAddress = view.findViewById(R.id.et_address);

        final ObjectMkd mkd = (ObjectMkd) (getArguments().getSerializable(MainActivity.MSG_NAME));
        setTVText(view, R.id.et_address, mkd.getAddress().toPrint());
        setTVText(view, R.id.et_house_number, mkd.getHouseNumber()+"");
        setTVText(view, R.id.et_house_block, ""+mkd.getHouseBlock());
        setTVText(view, R.id.et_seria, ""+mkd.getSeria());
        setTVText(view, R.id.et_year, ""+mkd.getYear());
        setTVText(view, R.id.et_square, ""+mkd.getSquare());
        setTVText(view, R.id.et_house_doors_count, ""+mkd.getHouseDoorsCount());
        setTVText(view, R.id.et_min_floor_count, ""+mkd.getMinFloorCount());
        setTVText(view, R.id.et_max_floor_count, ""+mkd.getMaxFloorCount());
        setTVText(view, R.id.et_accounts_count, ""+mkd.getAccountsCount());
        setTVText(view, R.id.et_persons_count, ""+mkd.getPersonsCount());
        setTVText(view, R.id.et_flats_count, ""+mkd.getFlatsCount());
        setTVText(view, R.id.et_rooms_count, ""+mkd.getRoomsCount());
        setTVText(view, R.id.et_area_square, ""+mkd.getAreaSquare());

        AppCompatButton btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!checkEmpty()) {
                    String add = getTvText(view, R.id.et_address);
                    mkd.getAddress().setLocality(add.split(",")[0].trim());
                    if (add.split(",").length > 1)
                        mkd.getAddress().setStreet(add.split(",")[1].trim());
                    mkd.setHouseNumber(getTvText(view, R.id.et_house_number));
                    mkd.setHouseBlock(getTvText(view, R.id.et_house_block));
                    mkd.setSeria(getTvText(view, R.id.et_seria));
                    mkd.setYear((int) getTvFloat(view, R.id.et_year));
                    mkd.setSquare(getTvFloat(view, R.id.et_square));
                    mkd.setHouseDoorsCount((int) getTvFloat(view, R.id.et_house_doors_count));
                    mkd.setMinFloorCount((int) getTvFloat(view, R.id.et_min_floor_count));
                    mkd.setMaxFloorCount((int) getTvFloat(view, R.id.et_max_floor_count));
                    mkd.setAccountsCount((int) getTvFloat(view, R.id.et_accounts_count));
                    mkd.setPersonsCount((int) getTvFloat(view, R.id.et_persons_count));
                    mkd.setFlatsCount((int) getTvFloat(view, R.id.et_flats_count));
                    mkd.setRoomsCount((int) getTvFloat(view, R.id.et_rooms_count));
                    mkd.setAreaSquare(getTvFloat(view, R.id.et_area_square));
                    MainActivity.mkdApi.saveMkd(mkd, (AppCompatActivity) getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().remove(ChangeMkdFragment.this).commit();

                }
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        ((MainActivity) getActivity()).update();
    }


}