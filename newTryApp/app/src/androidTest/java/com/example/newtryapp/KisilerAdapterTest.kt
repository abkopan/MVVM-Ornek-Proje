package com.example.newtryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.databinding.CardTasarimBinding
import com.example.newtryapp.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class KisilerAdapterTest {

    private lateinit var context: Context
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var kisilerListesi: List<Kisiler>
    private lateinit var adapter: KisilerAdapter

    @Before
    fun setUp() {
        context = mock(Context::class.java)
        viewModel = mock(AnasayfaViewModel::class.java)

        kisilerListesi = listOf(
            Kisiler(1, "Ali", "123456"),
            Kisiler(2, "Veli", "789101"),
            Kisiler(3, "Ayşe", "112131")
        )

        adapter = KisilerAdapter(context, kisilerListesi, viewModel)
    }

    @Test
    fun testGetItemCount() {
        // Adapter'ın eleman sayısını kontrol et
        assertEquals(3, adapter.itemCount)
    }

    @Test
    fun testOnBindViewHolder() {
        // ViewHolder'ı oluştur
        val inflater = LayoutInflater.from(context)
        val parent = mock(ViewGroup::class.java)
        val binding = CardTasarimBinding.inflate(inflater, parent, false)
        val viewHolder = adapter.CardTasarimTutucu(binding)

        // Birinci öğeyi bağla
        adapter.onBindViewHolder(viewHolder, 0)

        // İlk öğenin isminin doğru atanıp atanmadığını kontrol et
        assertEquals("Ali", viewHolder.binding.kisiNesnesi?.kisi_adi)
    }

    @Test
    fun testSilButonuTiklama() {
        // ViewHolder'ı oluştur
        val inflater = LayoutInflater.from(context)
        val parent = mock(ViewGroup::class.java)
        val binding = CardTasarimBinding.inflate(inflater, parent, false)
        val viewHolder = adapter.CardTasarimTutucu(binding)

        // Birinci öğeyi bağla ve silme butonuna tıklama simülasyonu yap
        adapter.onBindViewHolder(viewHolder, 0)
        binding.imageViewSil.performClick()

        // ViewModel'de silme fonksiyonunun doğru ID ile çağrıldığını doğrula
        verify(viewModel).sil(1)
    }
}
