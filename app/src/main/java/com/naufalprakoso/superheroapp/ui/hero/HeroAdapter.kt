package com.naufalprakoso.superheroapp.ui.hero

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.util.UtilUi
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroAdapter(
    private val context: Context,
    private val clickListener: (Long) -> Unit
) : PagedListAdapter<Superhero, HeroAdapter.ViewHolder>(HeroDiffCallback) {

    companion object {
        val HeroDiffCallback = object : DiffUtil.ItemCallback<Superhero>() {
            override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean =
                oldItem.hero.id == newItem.hero.id &&
                oldItem.hero.name == newItem.hero.name &&
                oldItem.biography.fullName == newItem.biography.fullName

            override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean =
                oldItem == newItem
        }
    }

    private val superheroes = arrayListOf<Superhero>()

    fun setHeroes(superheroes: List<Superhero>) {
        this.superheroes.clear()
        this.superheroes.addAll(superheroes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
    )

    override fun getItemCount(): Int = superheroes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(context, superheroes[position], clickListener)
    }

    override fun getItemId(position: Int): Long {
        return superheroes[position].hero.id.hashCode().toLong()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(context: Context, superhero: Superhero, clickListener: (Long) -> Unit) {
            val image = superhero.image.md
            val hero = superhero.hero
            val race = superhero.appearance.getRace

            Glide.with(context).asBitmap().apply(UtilUi.imageHero()).load(image).into(itemView.ivHero)
            itemView.tvName.text = hero.name
            itemView.tvRace.text = race

            itemView.setOnClickListener { clickListener(hero.id) }
            itemView.cvImg.setOnClickListener { clickListener(hero.id) }
        }
    }
}