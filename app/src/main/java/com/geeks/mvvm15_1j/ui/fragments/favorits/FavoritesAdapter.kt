package com.geeks.mvvm15_1j.ui.fragments.favorits

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.mvvm15_1j.data.model.RickAndMortyCharacter
import com.geeks.mvvm15_1j.databinding.ItemCharactersBinding
import com.geeks.mvvm15_1j.ui.fragments.characters.CharacterAdapter

class FavoritesAdapter(private val click: CharacterAdapter.AddFavorites):RecyclerView.Adapter<FavoritesAdapter.CharacterViewHolder>() {
    private var list = listOf<RickAndMortyCharacter>()

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacter(list: List<RickAndMortyCharacter>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    class CharacterViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(character: RickAndMortyCharacter) {
            binding.itemTvCharacterName.text = character.name
            binding.itemTvGender.text = character.gender
            binding.itemTvStatus.text = character.status
            binding.itemTvType.text = character.species
            Glide.with(binding.root).load(character.image).centerCrop()
                .into(binding.itemImgCharacter)

            when (character.status) {
                "Alive" -> binding.itemStatusColor.setBackgroundColor(Color.GREEN)
                "Dead" -> binding.itemStatusColor.setBackgroundColor(Color.RED)
                "unknown" -> binding.itemStatusColor.setBackgroundColor(Color.GRAY)
            }
        }
    }
}

