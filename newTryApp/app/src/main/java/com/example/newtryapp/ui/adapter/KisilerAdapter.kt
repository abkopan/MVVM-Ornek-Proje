package com.example.newtryapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newtryapp.R
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.databinding.CardTasarimBinding
import com.example.newtryapp.ui.fragment.AnaSayfaFragment
import com.example.newtryapp.ui.fragment.AnaSayfaFragmentDirections
import com.example.newtryapp.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

open class KisilerAdapter(var mContext: Context,var kisilerListesi:List<Kisiler> , var viewModel: AnasayfaViewModel):
    RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(binding:CardTasarimBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardTasarimBinding
        init{
            this.binding=binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val binding:CardTasarimBinding=DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi=kisilerListesi.get(position)
        holder.binding.kisiNesnesi=kisi

        holder.binding.satirCard.setOnClickListener{
            val gecis=AnaSayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        holder.binding.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_adi} silinsin mi ?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }
    }
}