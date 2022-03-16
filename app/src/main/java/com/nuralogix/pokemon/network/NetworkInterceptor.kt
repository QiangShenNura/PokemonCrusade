package com.nuralogix.pokemon.network

import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.StringUtils
import com.blankj.utilcode.util.ToastUtils
import com.nuralogix.pokemon.R
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShort(StringUtils.getString(R.string.network_connection_error))
        }
        return chain.proceed(chain.request())
    }
}