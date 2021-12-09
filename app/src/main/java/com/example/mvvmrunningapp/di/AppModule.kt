package com.example.mvvmrunningapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.mvvmrunningapp.db.RunningDatabase
import com.example.mvvmrunningapp.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.mvvmrunningapp.other.Constants.KEY_NAME
import com.example.mvvmrunningapp.other.Constants.KEY_WEIGHT
import com.example.mvvmrunningapp.other.Constants.RUNNING_DATABASE_NAME
import com.example.mvvmrunningapp.other.Constants.SHARE_PREFERENCE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* ApplicationComponent used to determine when the objects inside of our app
* module are created and when they are destroyed
* */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app:Context
    ) = Room.databaseBuilder(app,RunningDatabase::class.java,RUNNING_DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideRunDAO(db:RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext app: Context): SharedPreferences =
        app.getSharedPreferences(SHARE_PREFERENCE_NAME,MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesName(sharePref:SharedPreferences) = sharePref.getString(KEY_NAME,"") ?: ""

    @Singleton
    @Provides
    fun providesWeight(sharePref:SharedPreferences) = sharePref.getFloat(KEY_WEIGHT,80f)

    @Singleton
    @Provides
    fun providesFirstTimeToggle(sharePref:SharedPreferences) = sharePref.getBoolean(
        KEY_FIRST_TIME_TOGGLE,true)

}