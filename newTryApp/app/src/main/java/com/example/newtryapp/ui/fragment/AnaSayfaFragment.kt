package com.example.newtryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtryapp.R
import com.example.newtryapp.data.entity.Kisiler
import com.example.newtryapp.databinding.FragmentAnaSayfaBinding
import com.example.newtryapp.ui.adapter.KisilerAdapter
import com.example.newtryapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener{
    private lateinit var binding:FragmentAnaSayfaBinding
    private lateinit var viewModel:AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)
        binding.anaSayfaFragment=this

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter=adapter
        }



        requireActivity().addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item=menu.findItem(R.id.action_ara)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnaSayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        // Klavyedeki arama ikonuna bastığımızda çalışacak olan fonksiyon
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        // Klavyede her harf giriş çıkışında çalışacak olan fonksiyon
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

    fun fabBtn(view:View){
        Navigation.findNavController(view).navigate(R.id.kisiKayitGecis)
    }

}