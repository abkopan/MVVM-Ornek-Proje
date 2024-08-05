package com.example.newtryapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newtryapp.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel@Inject constructor(var krepo : KisilerDaoRepository): ViewModel() {

    fun kayit(kisi_adi:String,kisi_tel:String){
        krepo.kisiKayit(kisi_adi,kisi_tel)
    }
}