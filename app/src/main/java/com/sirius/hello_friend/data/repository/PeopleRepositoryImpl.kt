package com.sirius.hello_friend.data.repository

import com.sirius.hello_friend.data.api.PeopleApi
import com.sirius.hello_friend.data.mapper.PeoplesResponseMapper
import com.sirius.hello_friend.domain.model.People
import com.sirius.hello_friend.domain.repository.PeopleRepository
import io.reactivex.rxjava3.core.Single

class PeopleRepositoryImpl(
    private val api: PeopleApi,
    private val mapper: PeoplesResponseMapper
) : PeopleRepository {
    override fun getPeoples(): Single<List<People>> {
        return api.getPeople().map { mapper.map(it) }
    }

    override fun getPeople(peopleId: String): Single<People> {
        return api.getPeopleById(peopleId).map { mapper.map(it) }
    }


}