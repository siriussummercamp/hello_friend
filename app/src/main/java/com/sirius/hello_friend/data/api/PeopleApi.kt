package com.sirius.hello_friend.data.api

import com.sirius.hello_friend.data.model.response.PeopleResponse
import com.sirius.hello_friend.data.model.response.PeoplesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApi {

    @GET("people")
    fun getPeople(): Single<PeoplesResponse>

    @GET("people/{peopleId}")
    fun getPeopleById(
        @Path("peopleId") peopleId: String
    ): Single<PeopleResponse>
}