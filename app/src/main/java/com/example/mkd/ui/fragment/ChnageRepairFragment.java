package com.example.mkd.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.mkd.R;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.data.model.RepairDataDTO;
import com.example.mkd.ui.main.MainActivity;


public class ChnageRepairFragment extends ChangeMkdFragment {


    private boolean checkEmpty() {
        boolean problem = false;
        return problem;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_change_repair, container, false);


        final ObjectMkd mkd = (ObjectMkd) (getArguments().getSerializable(MainActivity.MSG_NAME));
        setTVText(view, R.id.tv_address, mkd.getAddress().toPrint());
        final RepairDataDTO repair = mkd.getRepair();
        setTVText(view, R.id.et_substructure, repair.getSubstructure()+"");
        setTVText(view, R.id.et_facade, ""+ repair.getFacade());
        setTVText(view, R.id.et_roof, ""+ repair.getRoof());
        setTVText(view, R.id.et_elevator, ""+ repair.getElevator());
        setTVText(view, R.id.et_energy, ""+ repair.getEnergy());
        setTVText(view, R.id.et_heating, ""+ repair.getHeating());
        setTVText(view, R.id.et_watter, ""+ repair.getWatter());
        setTVText(view, R.id.et_hot_watter, ""+ repair.getHotWatter());
        setTVText(view, R.id.et_watter_out, ""+ repair.getWatterOut());
        setTVText(view, R.id.et_other, ""+ repair.getOther());

        AppCompatButton btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!checkEmpty()) {
                    repair.setSubstructure((int) getTvFloat(view, R.id.et_substructure));
                    repair.setFacade((int) getTvFloat(view, R.id.et_facade));
                    repair.setRoof((int) getTvFloat(view, R.id.et_roof));
                    repair.setElevator((int) getTvFloat(view, R.id.et_elevator));
                    repair.setEnergy((int) getTvFloat(view, R.id.et_energy));
                    repair.setHeating((int) getTvFloat(view, R.id.et_heating));
                    repair.setWatter((int) getTvFloat(view, R.id.et_watter));
                    repair.setHotWatter((int) getTvFloat(view, R.id.et_hot_watter));
                    repair.setWatterOut((int) getTvFloat(view, R.id.et_watter_out));
                    repair.setOther((int) getTvFloat(view, R.id.et_other));
                    MainActivity.mkdApi.saveMkdRepair(mkd, (AppCompatActivity) getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().remove(ChnageRepairFragment.this).commit();

                }
            }
        });

        return view;
    }


}