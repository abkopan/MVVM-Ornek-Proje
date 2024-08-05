package com.example.newtryapp.di

import android.content.Context
import androidx.room.Room
import com.example.newtryapp.data.repo.KisilerDaoRepository
import com.example.newtryapp.room.KisilerDao
import com.example.newtryapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao:KisilerDao) : KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }


    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao{

        val vt = Room.databaseBuilder(context,Veritabani::class.java,"rehber.sqlite").createFromAsset("rehber.sqlite").build()

        return vt.getKisilerDao()
    }
}