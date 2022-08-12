package com.sirius.hello_friend.ui.di

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory<T : ViewModel> @Inject constructor(private val viewModel: Provider<T>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel.get() as T
    }

    inline fun <reified T : ViewModel> getViewModel(fragment: Fragment): T {
        val viewModelProvider = ViewModelProvider(fragment.viewModelStore, this)
        return viewModelProvider[T::class.java]
    }

    inline fun <reified T : ViewModel> getViewModel(activity: ComponentActivity): T {
        val viewModelProvider = ViewModelProvider(activity.viewModelStore, this)
        return viewModelProvider[T::class.java]
    }

}