package com.example.newtryapp.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class KisilerDaoRepository (var kdao:KisilerDao){
    val kisilerListesi : MutableLiveData<List<Kisiler>>
            init{
                kisilerListesi= MutableLiveData()
            }

    fun kisiKayit(kisi_adi:String,kisi_tel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi=Kisiler(0,kisi_adi,kisi_tel)
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun kisiGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi=Kisiler(kisi_id,kisi_ad,kisi_tel)
            kdao.kisiGuncelle(guncellenenKisi)
        }
    }

    fun kisiAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.kisiArama(aramaKelimesi)
        }
    }

    fun kisiSil(kisi_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi=Kisiler(kisi_id,"","")
            kdao.kisiGuncelle(silinenKisi)
            tumKisileriAl()
        }
    }

    fun tumKisileriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.tumKisiler()
        }
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

}