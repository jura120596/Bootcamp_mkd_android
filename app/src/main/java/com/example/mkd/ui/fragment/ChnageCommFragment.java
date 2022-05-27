package com.example.mkd.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.mkd.R;
import com.example.mkd.data.adapter.ArraySpinnerAdapter;
import com.example.mkd.data.model.CommincationDTODataField;
import com.example.mkd.data.model.CommunicationDTO;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.ui.main.MainActivity;
import com.google.gson.Gson;


public class ChnageCommFragment extends ChangeMkdFragment {


    private boolean checkEmpty() {
        boolean problem = false;
        return problem;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_change_comm, container, false);
        setSpinners(view);
        final ObjectMkd mkd = (ObjectMkd) (getArguments().getSerializable(MainActivity.MSG_NAME));
        setTVText(view, R.id.tv_address, mkd.getAddress().toPrint());
        final CommunicationDTO comm = mkd.getCommunication();
        CommincationDTODataField o = new Gson().fromJson(comm.getData(), CommincationDTODataField.class);
        sp_heating.setSelection(o.getHeating());
        sp_watter.setSelection(o.getWatter());
        sp_hot_watter.setSelection(o.getHotWatter());
        AppCompatButton btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!checkEmpty()) {
                    CommincationDTODataField df = new CommincationDTODataField();
                    df.setHeating(sp_heating.getSelectedItemPosition());
                    df.setWatter(sp_watter.getSelectedItemPosition());
                    df.setHotWatter(sp_hot_watter.getSelectedItemPosition());
                    comm.setData(new Gson().toJson(df));
                    MainActivity.mkdApi.saveMkdComm(mkd, (AppCompatActivity) getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().remove(ChnageCommFragment.this).commit();

                }
            }
        });

        return view;
    }

    private AppCompatSpinner sp_heating,sp_watter, sp_hot_watter;
    private ArraySpinnerAdapter heatingSpinnerAdapter, wSA,hWSA;
    public void setSpinners(View v) {
        sp_heating = v.findViewById(R.id.sp_heating);
        String[] heatings = {"Центральное", "Децентрализованное", "Индивидуальное",
        "Печное","Автономная котельная","Нет","Иное"};
        heatingSpinnerAdapter =
                new ArraySpinnerAdapter(
                        getActivity(),
                        R.layout.spinner_item,
                        heatings
                );
        sp_heating.setAdapter(heatingSpinnerAdapter);
        sp_watter = v.findViewById(R.id.sp_watter);
        String[] watters = {"Центральное", "Отсутствует", "Иное"};
        wSA =
                new ArraySpinnerAdapter(
                        getActivity(),
                        R.layout.spinner_item,
                        watters
                );
        sp_watter.setAdapter(wSA);
        sp_hot_watter = v.findViewById(R.id.sp_hot_watter);
        hWSA =
                new ArraySpinnerAdapter(
                        getActivity(),
                        R.layout.spinner_item,
                        watters
                );
        sp_hot_watter.setAdapter(hWSA);
    }


}