package com.searoth.adesa

import android.app.Application
import com.searoth.adesa.di.ServiceInitializer

class AdesaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceInitializer.initServices(this)
    }
}