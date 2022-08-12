package com.sirius.hello_friend.ui.activity

import CharactersScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.graphics.Color
import com.sirius.hello_friend.ui.di.ViewModelFactory
import com.sirius.hello_friend.ui.model.PeopleViewState
import com.sirius.hello_friend.ui.theme.HelloFriendTheme
import com.sirius.hello_friend.ui.viewmodel.PeopleVM
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : ComponentActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var vmFactory: ViewModelFactory<PeopleVM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = vmFactory.getViewModel<PeopleVM>(this)
        setContent {
            HelloFriendTheme(darkTheme = true) {
                Surface(contentColor = Color.LightGray) {
                    MainScreen(vm)
                }
            }
        }
        vm.consume()
    }

    @Composable
    private fun MainScreen(vm: PeopleVM) {
        CharactersScreen(
            state = vm.viewStates.subscribeAsState(
                initial = PeopleViewState(isLoading = true)
            )
        )
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}

