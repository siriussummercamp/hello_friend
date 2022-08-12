package com.sirius.hello_friend.ui.di

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector

class AppInjector(
    private val app: Application,
) {

    init {
        val activityLifecycleCallbacks = object : ActivityLifecycleCallbacks {

            override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
                super.onActivityPreCreated(activity, savedInstanceState)
                if (activity is HasAndroidInjector)
                    AndroidInjection.inject(activity)
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

        }

        app.registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }


}