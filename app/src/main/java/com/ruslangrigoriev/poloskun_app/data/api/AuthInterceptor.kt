package com.ruslangrigoriev.poloskun_app.data.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequest = original.newBuilder()
            //TODO заменить
            .addHeader("Bearer-Authorization", "d35ca962-7a23-4104-b1ce-2343f6f96093")
            .method(original.method(), original.body())
            .build();
        return chain.proceed(newRequest)
    }
}