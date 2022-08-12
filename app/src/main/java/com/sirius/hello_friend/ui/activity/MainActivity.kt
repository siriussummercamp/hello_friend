package com.sirius.hello_friend.ui.activity

import CharactersScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.graphics.Color
import com.sirius.hello_friend.ui.model.PeopleViewState
import com.sirius.hello_friend.ui.theme.HelloFriendTheme
import com.sirius.hello_friend.ui.viewmodel.PeopleVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: PeopleVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}

