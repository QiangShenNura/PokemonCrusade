package com.nuralogix.pokemon.network

import com.nuralogix.pokemon.network.api.Api
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


/**
 * Created by Qiang Shen on 2022/3/16.
 */
class MoreBaseUrlInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val oldUrl: HttpUrl = originalRequest.url
        val builder: Request.Builder = originalRequest.newBuilder()
        //get head message
        val urlnameList: List<String> = originalRequest.headers("urlname")
        return if (urlnameList.isNotEmpty()) {
            //delete old data
            builder.removeHeader("urlname")
            //find head value and match
            val urlname = urlnameList[0]
            var baseURL: HttpUrl? = null
            if ("space_list" == urlname) {
                baseURL = Api.LIST_BASE_URL.toHttpUrlOrNull()
            } else if ("detail_list" == urlname) {
                baseURL = Api.DETAIL_BASE_URL.toHttpUrlOrNull()
            }
            //rebuild url
            val newHttpUrl = oldUrl.newBuilder()
                .scheme(baseURL!!.scheme)
                .host(baseURL.host)
                .port(baseURL.port)
                .build()
            //get new request
            val newRequest: Request = builder.url(newHttpUrl).build()
            chain.proceed(newRequest)
        } else {
            chain.proceed(originalRequest)
        }
    }
}