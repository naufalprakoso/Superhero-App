package com.naufalprakoso.superheroapp.ui.antihero

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.databinding.ItemHeroBinding
import com.naufalprakoso.superheroapp.util.UtilUi

class AntiHeroAdapter(
    context: Context,
    private val clickListener: (Long) -> Unit
) : RecyclerView.Adapter<AntiHeroAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ItemHeroBinding

    private val antiHeroes = arrayListOf<Superhero>()

    fun setAntiHeroes(superheroes: List<Superhero>) {
        this.antiHeroes.clear()
        this.antiHeroes.addAll(superheroes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemHeroBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = antiHeroes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(binding, antiHeroes[position], clickListener)
    }

    override fun getItemId(position: Int): Long {
        return antiHeroes[position].hero.id.hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(
            binding: ItemHeroBinding,
            superhero: Superhero,
            clickListener: (Long) -> Unit
        ) {
            val image = superhero.image.md
            val hero = superhero.hero
            val race = superhero.appearance.getRace

            Glide.with(binding.root.context).asBitmap().apply(UtilUi.imageHero()).load(image)
                .into(binding.ivHero)
            binding.tvName.text = hero.name
            binding.tvRace.text = race

            binding.root.setOnClickListener { clickListener(hero.id) }
            binding.cvImg.setOnClickListener { clickListener(hero.id) }
        }
    }
}