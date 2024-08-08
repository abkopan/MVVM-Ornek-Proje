package com.example.newtryapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newtryapp.data.repo.KisilerDaoRepository
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class KisiDetayViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val krepo = mock(KisilerDaoRepository::class.java)
    private val viewModel = KisiDetayViewModel(krepo)

    @Test
    fun `test guncelle çağırıldığında kisiGuncelle çağrılır`() {
        val kisiId = 1
        val kisiAd = "Arda Kopan"
        val kisiTel = "1234567890"

        viewModel.guncelle(kisiId, kisiAd, kisiTel)

        verify(krepo, times(1)).kisiGuncelle(kisiId, kisiAd, kisiTel)
    }
}
