package com.example.newtryapp.data.entity

import org.junit.Assert.assertEquals
import org.junit.Test

class KisilerTest {

    @Test
    fun `test Kisiler creation`() {
        // Arrange
        val kisiId = 1
        val kisiAdi = "Ahmet"
        val kisiTel = "1234567890"

        // Act
        val kisi = Kisiler(kisiId, kisiAdi, kisiTel)

        // Assert
        assertEquals(kisiId, kisi.kisi_id)
        assertEquals(kisiAdi, kisi.kisi_adi)
        assertEquals(kisiTel, kisi.kisi_tel)
    }

    @Test
    fun `test Kisiler data modification`() {
        // Arrange
        val kisi = Kisiler(1, "Ahmet", "1234567890")

        // Act
        kisi.kisi_adi = "Mehmet"
        kisi.kisi_tel = "0987654321"

        // Assert
        assertEquals("Mehmet", kisi.kisi_adi)
        assertEquals("0987654321", kisi.kisi_tel)
    }
}
