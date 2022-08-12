package com.sirius.hello_friend.data.mapper

import com.sirius.hello_friend.data.model.response.PeopleResponse
import com.sirius.hello_friend.data.model.response.PeoplesResponse
import com.sirius.hello_friend.domain.model.Gender
import com.sirius.hello_friend.domain.model.People
import javax.inject.Inject

class PeoplesResponseMapper /*@Inject*/ constructor() {

    fun map(data: PeoplesResponse): List<People> {
        return data.results.map { map(it) }
    }

    fun map(data: PeopleResponse): People {
        val height = data.height?.toIntOrNull() ?: 0
        val mass = data.mass?.toIntOrNull() ?: 0
        val gender = Gender.values().firstOrNull { it.value == data.gender } ?: Gender.OTHER
        return People(
            name = data.name.orEmpty(),
            height = height,
            mass = mass,
            gender = gender,
            hairColor = data.hairColor.orEmpty(),
            skinColor = data.skinColor.orEmpty()
        )
    }
}