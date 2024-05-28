package com.aah.movies.di

import com.aah.data.network.ApiService
import com.aah.data.repoImplementation.RepoImplementation
import com.aah.domain.repo.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService) : MovieRepo {
        return RepoImplementation(apiService)
    }

}