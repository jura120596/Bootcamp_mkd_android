package com.example.mkd.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mkd.Storage;
import com.example.mkd.data.model.CommunicationDTO;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.data.model.RepairDataDTO;
import com.example.mkd.retrofit.retorfitservices.ObjectControllerService;
import com.example.mkd.ui.main.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MkdRetrofit {

    private static Retrofit instance;
    static {
        instance = getRetrofit();
    }
    public static Retrofit getRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public void fillMkd(final AppCompatActivity a) {
        ObjectControllerService s = instance.create(ObjectControllerService.class);
        Call<List<ObjectMkd>> mkdList = s.getMkdList();
        mkdList.enqueue(new Callback<List<ObjectMkd>>() {
            @Override
            public void onResponse(Call<List<ObjectMkd>> call, Response<List<ObjectMkd>> response) {
                System.out.println(response.code());
                System.out.println(response.body().toString());
                Storage.MKD_LIST.clear();
                Storage.MKD_LIST.addAll(response.body());
                if (a instanceof MainActivity) ((MainActivity) a).update();
            }

            @Override
            public void onFailure(Call<List<ObjectMkd>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void fillGenre() {
    }

    public void fillAuthor() {
    }
    public void deleteMkd(long id) {
    }


    public void saveMkd(final ObjectMkd mkd, final AppCompatActivity activity) {
        ObjectControllerService s = instance.create(ObjectControllerService.class);
        Call<ObjectMkd> c;
        if (mkd.getId() > 0) {
            c = s.update(mkd);
        } else {
            c = s.create(mkd);
        }
        c.enqueue(new Callback<ObjectMkd>() {
            @Override
            public void onResponse(Call<ObjectMkd> call, Response<ObjectMkd> response) {
                if (response.code() == 200) {
                    fillMkd(activity);
                }
            }

            @Override
            public void onFailure(Call<ObjectMkd> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void saveMkdRepair(ObjectMkd mkd, final AppCompatActivity activity) {

        ObjectControllerService s = instance.create(ObjectControllerService.class);
        Call<RepairDataDTO> c = s.saveRepair(mkd.getId(), mkd.getRepair());
        c.enqueue(new Callback<RepairDataDTO>() {
            @Override
            public void onResponse(Call<RepairDataDTO> call, Response<RepairDataDTO> response) {
                if (response.code() == 200) {
                    fillMkd(activity);
                }
            }

            @Override
            public void onFailure(Call<RepairDataDTO> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void saveMkdComm(ObjectMkd mkd, final AppCompatActivity activity) {

        ObjectControllerService s = instance.create(ObjectControllerService.class);
        Call<CommunicationDTO> c = s.saveComm(mkd.getId(), mkd.getCommunication());
        c.enqueue(new Callback<CommunicationDTO>() {
            @Override
            public void onResponse(Call<CommunicationDTO> call, Response<CommunicationDTO> response) {
                if (response.code() == 200) {
                    fillMkd(activity);
                }
            }

            @Override
            public void onFailure(Call<CommunicationDTO> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
