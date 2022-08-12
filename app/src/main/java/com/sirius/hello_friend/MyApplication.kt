package com.sirius.hello_friend

import android.app.Application
import com.sirius.hello_friend.ui.di.AppComponent
import com.sirius.hello_friend.ui.di.AppInjector
import com.sirius.hello_friend.ui.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector

class MyApplication : Application(), HasAndroidInjector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = buildAppComponent()
        val appInjector = AppInjector(this)
        appComponent.inject(this)
    }

    fun buildAppComponent() : AppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun androidInjector(): AndroidInjector<Any> = appComponent.dispatchingAndroidInjector
}