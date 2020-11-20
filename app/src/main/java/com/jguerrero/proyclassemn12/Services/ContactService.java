package com.jguerrero.proyclassemn12.Services;

import com.jguerrero.proyclassemn12.Clases.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ContactService {

    @GET("60ad16ac-f964-4c16-96c9-ea8c5597f3a9") //se coloca sin el / al inicio
    Call<List<Contacto>> getAll();
    @GET("60ad16ac-f964-4c16-96c9-ea8c5597f3a9")
    Call<List<Contacto>> getByQuery(@Query("query") String query);

    @POST("60ad16ac-f964-4c16-96c9-ea8c5597f3a9")
    Call<Contacto> create(@Body Contacto contacto); // para enviar datos se usa @Body y el nombre de la clase
}
