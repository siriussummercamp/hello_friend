package com.sirius.hello_friend.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import CharactersScreen
import androidx.compose.runtime.rxjava3.subscribeAsState
import com.sirius.hello_friend.ui.model.PeopleViewState
import com.sirius.hello_friend.ui.theme.HelloFriendTheme
import com.sirius.hello_friend.ui.viewmodel.PeopleVM

class MainActivity : ComponentActivity() {

    //todo Inject vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloFriendTheme(darkTheme = true) {
                Surface(contentColor = Color.LightGray) {
                    //MainScreen()
                }
            }
        }
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

