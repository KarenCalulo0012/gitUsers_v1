package com.appscals.gitcloneapp.di

import com.appscals.gitcloneapp.data.remote.ApiInterface
import com.appscals.gitcloneapp.data.repository.DataSource
import com.appscals.gitcloneapp.domain.repository.DataRepository
import com.appscals.gitcloneapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofitApi(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRepository(api: ApiInterface) : DataRepository {
        return DataSource(api)
    }
}