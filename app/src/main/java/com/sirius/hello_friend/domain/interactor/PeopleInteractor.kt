package com.sirius.hello_friend.domain.interactor

import com.sirius.hello_friend.domain.model.People
import com.sirius.hello_friend.domain.repository.PeopleRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PeopleInteractor /*@Inject*/ constructor(
    private val repository: PeopleRepository
) {

    fun getPeoples(): Single<List<People>> {
        return repository.getPeoples()
    }

    fun getPeopleById(peopleId: String): Single<People> {
        return repository.getPeople(peopleId)
    }
}