package com.sirius.hello_friend.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sirius.hello_friend.domain.interactor.PeopleInteractor
import com.sirius.hello_friend.ui.model.PeopleViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import javax.inject.Inject

//@HiltViewModel
class PeopleVM /*@Inject*/ constructor(
    private val interactor: PeopleInteractor
) : ViewModel() {

    private val _viewStateBehaviorProcessor = BehaviorProcessor.create<PeopleViewState>()

    val viewStates: Flowable<PeopleViewState> = _viewStateBehaviorProcessor

    fun consume(/* uiEvent */) {}

    override fun onCleared() {
        super.onCleared()
    }

}