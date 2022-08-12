package com.sirius.hello_friend.domain.model

data class People(
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: String,
    val skinColor: String,
    val gender: Gender,
)