package com.nuralogix.pokemon.network

import android.util.Log
import androidx.viewbinding.BuildConfig
import com.nuralogix.pokemon.network.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class RetrofitFactory {
    private val TIMEOUT = 20

    val service by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
        getService(Api::class.java)
    }

    companion object{
        val instance: RetrofitFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitFactory()
        }
    }

    private fun <T> getService(
        serviceClass: Class<T>
    ): T {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
             //TODO add exception handler
            .baseUrl(Api.LIST_BASE_URL)
        return retrofit.build().create(serviceClass)
    }

    private val okHttpClient: OkHttpClient
        get() {
            val mOkHttpClientBuilder = OkHttpClient.Builder()
            mOkHttpClientBuilder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            mOkHttpClientBuilder.readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            mOkHttpClientBuilder.writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            mOkHttpClientBuilder.retryOnConnectionFailure(true)
            // add network interceptor
            mOkHttpClientBuilder.addInterceptor(NetworkInterceptor())
            // add log interceptor
            mOkHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC
            })
            mOkHttpClientBuilder.addInterceptor(MoreBaseUrlInterceptor())
            // TODO  need to deal with server error and exceptions
            // TODO  add any interceptor if we need!
            return mOkHttpClientBuilder.build()
        }
}