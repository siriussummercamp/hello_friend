package com.sirius.hello_friend.data.model.response

import com.google.gson.annotations.SerializedName

class PeoplesResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<PeopleResponse>
)