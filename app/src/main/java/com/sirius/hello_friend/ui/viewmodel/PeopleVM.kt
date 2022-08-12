package com.sirius.hello_friend.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sirius.hello_friend.domain.interactor.PeopleInteractor
import com.sirius.hello_friend.ui.model.PeopleViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PeopleVM @Inject constructor(
    private val interactor: PeopleInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _viewStateBehaviorProcessor = BehaviorProcessor.create<PeopleViewState>()
    val viewStates: Flowable<PeopleViewState> = _viewStateBehaviorProcessor

    fun consume(/* uiEvent */) {
        compositeDisposable.add(
            interactor.getPeoples()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           _viewStateBehaviorProcessor.offer(
                               PeopleViewState(
                                   isLoading = false,
                                   errorText = "",
                                   data = it
                               )
                           )
                }, {
                    it.localizedMessage?.let { it1 -> Log.e("err", it1) }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}