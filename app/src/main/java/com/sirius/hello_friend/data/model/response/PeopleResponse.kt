package com.sirius.hello_friend.data.model.response

import com.google.gson.annotations.SerializedName

class PeopleResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("mass")
    val mass: String?,
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("gender")
    val gender: String?
)