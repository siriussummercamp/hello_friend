package com.sirius.hello_friend.ui.model

import com.sirius.hello_friend.domain.model.People

class PeopleViewState(
    val isLoading: Boolean = false,
    val errorText: String = "",
    val data: List<People> = emptyList()
) {

    val isError: Boolean = errorText.isNotBlank()

}