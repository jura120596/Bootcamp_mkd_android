package com.example.mkd.retrofit.retorfitservices;

import com.example.mkd.data.model.CommunicationDTO;
import com.example.mkd.data.model.ObjectMkd;
import com.example.mkd.data.model.RepairDataDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ObjectControllerService {
    @GET("object/")
    Call<List<ObjectMkd>> getMkdList();

    @POST("object/")
    Call<ObjectMkd> create(@Body ObjectMkd mkd);

    @PUT("object/update")
    Call<ObjectMkd> update(@Body ObjectMkd mkd);
    @PUT("object/{id}/repair")
    Call<RepairDataDTO> saveRepair(@Path("id") Long id, @Body RepairDataDTO mkd);

    @PUT("object/{id}/comm")
    Call<CommunicationDTO> saveComm(@Path("id") Long id, @Body CommunicationDTO communication);
}
