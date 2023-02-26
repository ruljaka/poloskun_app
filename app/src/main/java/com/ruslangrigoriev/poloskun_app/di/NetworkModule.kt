package com.ruslangrigoriev.poloskun_app.di

import com.ruslangrigoriev.poloskun_app.data.api.AuthInterceptor
import com.ruslangrigoriev.poloskun_app.data.api.ProductApi
import com.ruslangrigoriev.poloskun_app.data.source.RemoteDataSource
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
    factory { RemoteDataSource(get()) }
}

const val BASE_URL = "https://poloskun-backend.herokuapp.com/"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): ProductApi =
    retrofit.create(ProductApi::class.java)




