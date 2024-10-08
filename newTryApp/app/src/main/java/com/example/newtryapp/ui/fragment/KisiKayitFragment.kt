package com.example.newtryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.newtryapp.R
import com.example.newtryapp.databinding.FragmentKisiKayitBinding
import com.example.newtryapp.ui.viewmodel.KisiDetayViewModel
import com.example.newtryapp.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding:FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container,false)
        binding.kisiKayitFragment=this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiKayitViewModel by viewModels()
        viewModel=tempViewModel
    }


     fun butonKaydet(kisi_adi:String,kisi_tel:String){
         viewModel.kayit(kisi_adi,kisi_tel)
     }


}