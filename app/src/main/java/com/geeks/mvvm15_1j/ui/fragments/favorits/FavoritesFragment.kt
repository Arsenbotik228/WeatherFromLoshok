package com.geeks.mvvm15_1j.ui.fragments.favorits

import androidx.lifecycle.ViewModelProvider
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.databinding.FragmentFavoritesBinding
import com.geeks.mvvm15_1j.ui.fragments.characters.CharactersViewModel

class FavoritesFragment: BaseFragment<FragmentFavoritesBinding>(){

  lateinit var adapter:FavoritesAdapter
  override fun getViewBinding() = FragmentFavoritesBinding.inflate(layoutInflater)
  private val viewModel: FavoritsViewModel by lazy {
    ViewModelProvider(requireActivity())[FavoritsViewModel::class.java]
  }
  override fun initialize() {
    binding.rvCharacters.adapter = adapter
  }
}

