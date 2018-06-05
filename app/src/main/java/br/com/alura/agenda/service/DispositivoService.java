package br.com.alura.agenda.service;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Victor on 14/04/2018.
 */

public interface DispositivoService {
    @POST("firebase/dispositivo")
    Call<Void> enviaToken(@Header("token") String token);

}