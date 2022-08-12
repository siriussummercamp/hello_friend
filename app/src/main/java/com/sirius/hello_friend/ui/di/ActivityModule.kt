package com.sirius.hello_friend.ui.di

import com.sirius.hello_friend.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

}