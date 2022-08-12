package com.sirius.hello_friend.di.module

import com.sirius.hello_friend.data.repository.PeopleRepositoryImpl
import com.sirius.hello_friend.domain.repository.PeopleRepository
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun peopleRepositoryProvider(repository: PeopleRepositoryImpl): PeopleRepository {
        return repository
    }
}