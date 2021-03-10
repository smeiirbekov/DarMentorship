package com.example.lecture9

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named("s1")
    @Singleton
    fun provideStr(): String {
        return "test string"
    }

    @Provides
    @Named("s2")
    fun provideStr2(): String {
        return "test string2"
    }


    @Provides
    fun provideInt(): MyObj {
        return MyObj(1, "ActivityModule")
    }


    @Provides
    @Singleton
    fun provideRepo(@ApplicationContext context: Context, obj: MyObj): TestRepository {
        return TestRepoImpl(context, obj)
    }

}