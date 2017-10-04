package de.ganddev.oboobs.di;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.ganddev.oboobs.BoobsViewModelFactory;
import de.ganddev.oboobs.data.BoobsRemoteDataSource;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bjornahlfeld on 04.10.17.
 */
@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    @Singleton
    @Provides
    BoobsRemoteDataSource provideBoobsService(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BoobsRemoteDataSource.ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BoobsRemoteDataSource.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new BoobsViewModelFactory(viewModelSubComponent.build());
    }
}
