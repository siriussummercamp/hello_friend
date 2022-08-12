package com.sirius.hello_friend.ui.di

import android.app.Application
import com.sirius.hello_friend.data.di.NetworkModule
import com.sirius.hello_friend.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ActivityModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent {

    val dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: Application)

}