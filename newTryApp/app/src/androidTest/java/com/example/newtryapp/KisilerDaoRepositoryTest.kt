package com.example.newtryapp

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.data.repo.KisilerDaoRepository
import com.example.newtryapp.room.KisilerDao
import com.example.newtryapp.room.Veritabani
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class KisilerDaoRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: Veritabani
    private lateinit var kisilerDao: KisilerDao
    private lateinit var repository: KisilerDaoRepository

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, Veritabani::class.java
        ).build()
        kisilerDao = db.getKisilerDao()
        repository = KisilerDaoRepository(kisilerDao)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun testKisiKayit() = runBlocking {
        repository.kisiKayit("Test Kisi", "1234567890")
        val allKisiler = repository.kisileriGetir().value
        assertTrue(allKisiler?.isNotEmpty() ?: false)
        assertEquals("Test Kisi", allKisiler?.get(0)?.kisi_adi)
    }

    @Test
    fun testKisiGuncelle() = runBlocking {
        repository.kisiKayit("Test Kisi", "1234567890")
        val allKisiler = repository.kisileriGetir().value
        val kisiId = allKisiler?.get(0)?.kisi_id ?: 0

        repository.kisiGuncelle(kisiId, "Updated Kisi", "0987654321")
        val updatedKisiler = repository.kisileriGetir().value
        assertEquals("Updated Kisi", updatedKisiler?.get(0)?.kisi_adi)
    }

    @Test
    fun testKisiAra() = runBlocking {
        repository.kisiKayit("Test Kisi", "1234567890")
        repository.kisiAra("Test")
        val foundKisiler = repository.kisileriGetir().value
        assertTrue(foundKisiler?.isNotEmpty() ?: false)
        assertEquals("Test Kisi", foundKisiler?.get(0)?.kisi_adi)
    }

    @Test
    fun testKisiSil() = runBlocking {
        repository.kisiKayit("Test Kisi", "1234567890")
        val allKisiler = repository.kisileriGetir().value
        Log.e("kişi","$allKisiler")
        val kisiId = allKisiler?.get(0)?.kisi_id ?: 0

        repository.kisiSil(kisiId)
        val updatedKisiler = repository.kisileriGetir().value
        assertTrue(updatedKisiler?.isEmpty() ?: true)
    }
}