package com.geeks.mvvm15_1j.ui.fragments.characters

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geeks.mvvm15_1j.common.Resource
import com.geeks.mvvm15_1j.core.BaseFragment
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import com.geeks.mvvm15_1j.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>(),CharacterAdapter.AddFavorites {
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)

    private lateinit var  adapter:CharacterAdapter
    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(requireActivity())[CharactersViewModel::class.java]
    }
    private var page = 1

    override fun initialize() {
        adapter = CharacterAdapter(this)
        binding.rvCharacters.adapter = adapter
        viewModel.getCharacter("", page = page)
    }
    private fun loadInfo(){
        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> binding.progress.isVisible = true
                is Resource.Success -> {
                    binding.progress.isGone = true
                    viewModel.getCharacter(name = "",page = page)
                    it.data?.results?.let { it1 -> adapter.setCharacter(it1) }
                }
                is Resource.Error -> {
                    binding.progress.isGone = true
                    Toast.makeText(
                        requireContext(),
                        "Упс! Произошла какая-то ошибка",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ololo", "${it.message}")
                }
            }
        }

    }

    override fun constructListeners() {
        binding.btnLoadMore.setOnClickListener{
            page ++
            loadInfo()

        }
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?,): Boolean {
                loadInfo()

                return true
            }
        })
    }

    override fun launchObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> binding.progress.isVisible = true
                is Resource.Success -> {
                    binding.progress.isGone = true
                    it.data?.results?.let { it1 -> adapter.setCharacter(it1) }
                }
                is Resource.Error -> {
                    binding.progress.isGone = true
                    Toast.makeText(
                        requireContext(),
                        "Упс! Произошла какая-то ошибка",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun addFavoritesCharacters(model: RickAndMortyCharacter) {
        viewModel.addFavoriteCharacters(model)
    }
}