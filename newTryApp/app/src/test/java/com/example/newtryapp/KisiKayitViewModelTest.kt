package com.example.newtryapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newtryapp.data.repo.KisilerDaoRepository
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class KisiKayitViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val krepo = mock(KisilerDaoRepository::class.java)
    private val viewModel = KisiKayitViewModel(krepo)

    @Test
    fun `test kayit çağırıldığında kisiKayit çağrılır`() {
        val kisiAdi = "Arda Kopan"
        val kisiTel = "1234567890"

        viewModel.kayit(kisiAdi, kisiTel)

        verify(krepo, times(1)).kisiKayit(kisiAdi, kisiTel)
    }
}
