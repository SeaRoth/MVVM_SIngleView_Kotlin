package com.searoth.adesa.di

import android.app.Application
import android.content.Context
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceInitializer {
    companion object {
        fun initServices(application: Application) {
            initApplication(application)
            initNewsApiService(application)
        }

        private fun initNewsApiService(application: Context) {
            //https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=3e050ffdc2724f60b6e37bf5da3acab0
            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            SeaRothServiceLocator.put(Retrofit::class.java, retrofit)

            application.let {
                val picasso = Picasso.Builder(it).build()
                SeaRothServiceLocator.put(Picasso::class.java, picasso)
            }
        }

        private fun initApplication(application: Application) {
            SeaRothServiceLocator.put(Application::class.java, application)
        }
    }
}
