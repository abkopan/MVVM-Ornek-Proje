import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.data.repo.KisilerDaoRepository
import com.example.newtryapp.ui.viewmodel.AnasayfaViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AnasayfaViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val krepo = mock(KisilerDaoRepository::class.java)
    private lateinit var viewModel: AnasayfaViewModel

    @Before
    fun setUp() {

        `when`(krepo.kisileriGetir()).thenReturn(MutableLiveData())
        doNothing().`when`(krepo).tumKisileriAl()


        viewModel = AnasayfaViewModel(krepo)
    }

    @Test
    fun `test kisileriYukle çağırıldığında tümKisileriAl çağrılır`() {
        viewModel.kisileriYukle()
        verify(krepo, times(1)).tumKisileriAl()
    }

    @Test
    fun `test ara fonksiyonu çağrıldığında kisiAra çağrılır`() {
        val aramaKelimesi = "test"
        viewModel.ara(aramaKelimesi)
        verify(krepo).kisiAra(aramaKelimesi)
    }

    @Test
    fun `test sil fonksiyonu çağrıldığında kisiSil çağrılır`() {
        val kisiId = 1
        viewModel.sil(kisiId)
        verify(krepo).kisiSil(kisiId)
    }

    @Test
    fun `test kisileriGetir observer`() {
        val observer = mock(Observer::class.java) as Observer<List<Kisiler>>
        viewModel.kisilerListesi.observeForever(observer)

        val kisilerList = listOf(Kisiler(1, "John Doe", "1234567890"))
        viewModel.kisilerListesi.postValue(kisilerList)
        verify(observer).onChanged(kisilerList)
    }
}
