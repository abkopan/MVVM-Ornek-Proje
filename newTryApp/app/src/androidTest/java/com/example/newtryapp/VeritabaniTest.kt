package com.example.newtryapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newtryapp.room.Veritabani
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.room.KisilerDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

@RunWith(AndroidJUnit4::class)
class VeritabaniTest {
    private lateinit var db: Veritabani
    private lateinit var kisilerDao: KisilerDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, Veritabani::class.java).build()
        kisilerDao = db.getKisilerDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadKisiler() = runBlocking {
        val kisi = Kisiler(0, "Test Kisi", "1234567890")
        kisilerDao.kisiEkle(kisi)
        val allKisiler = kisilerDao.tumKisiler()
        assertThat(allKisiler.isNotEmpty(), equalTo(true))
        assertThat(allKisiler[0].kisi_adi, equalTo(kisi.kisi_adi))
    }

    @Test
    fun searchKisiler() = runBlocking {
        val kisi = Kisiler(0, "Test Kisi", "1234567890")
        kisilerDao.kisiEkle(kisi)
        val foundKisiler = kisilerDao.kisiArama("Test")
        assertThat(foundKisiler.isNotEmpty(), equalTo(true))
        assertThat(foundKisiler[0].kisi_adi, equalTo(kisi.kisi_adi))
    }

    @Test
    fun updateKisiler() = runBlocking {
        val kisi = Kisiler(0, "Test Kisi", "1234567890")
        kisilerDao.kisiEkle(kisi)
        val insertedKisi = kisilerDao.tumKisiler()[0]
        val updatedKisi = Kisiler(insertedKisi.kisi_id, "Updated Kisi", "0987654321")
        kisilerDao.kisiGuncelle(updatedKisi)
        val allKisiler = kisilerDao.tumKisiler()
        assertThat(allKisiler[0].kisi_adi, equalTo("Updated Kisi"))
    }

    @Test
    fun deleteKisiler() = runBlocking {
        val kisi = Kisiler(0, "Test Kisi", "1234567890")
        kisilerDao.kisiEkle(kisi)
        val insertedKisi = kisilerDao.tumKisiler()[0]
        kisilerDao.kisiSil(insertedKisi)
        val allKisiler = kisilerDao.tumKisiler()
        assertThat(allKisiler.isEmpty(), equalTo(true))
    }
}
