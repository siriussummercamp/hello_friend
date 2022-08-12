package com.sirius.hello_friend.di.module

import com.sirius.hello_friend.data.repository.PeopleRepositoryImpl
import com.sirius.hello_friend.domain.repository.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun peopleRepositoryProvider(repository: PeopleRepositoryImpl): PeopleRepository {
        return repository
    }
}