package br.com.alura.agenda.retrofit;

import br.com.alura.agenda.service.AlunoService;
import br.com.alura.agenda.service.DispositivoService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Victor on 17/03/2018.
 */

public class RetrofitInicializador {
    private final Retrofit retrofit;

    public RetrofitInicializador() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client =  new OkHttpClient.Builder();
        client.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public AlunoService getAlunoService() {
        return retrofit.create(AlunoService.class);
    }

    public DispositivoService getDispositivoService(){
        return retrofit.create(DispositivoService.class);
    }
}
