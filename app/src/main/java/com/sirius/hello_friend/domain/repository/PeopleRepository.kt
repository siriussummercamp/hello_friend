package com.sirius.hello_friend.domain.repository

import com.sirius.hello_friend.domain.model.People
import io.reactivex.rxjava3.core.Single

interface PeopleRepository {

    fun getPeoples(): Single<List<People>>

    fun getPeople(peopleId: String): Single<People>
}