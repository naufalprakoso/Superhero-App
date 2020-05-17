package com.naufalprakoso.superheroapp.ui.villain

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

class VillainAdapter(
    private val context: Context,
    private val clickListener: (Long) -> Unit
) : PagedListAdapter<Superhero, VillainAdapter.ViewHolder>(HeroDiffCallback) {

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

    private val villains = arrayListOf<Superhero>()

    fun setVillains(superheroes: List<Superhero>) {
        this.villains.clear()
        this.villains.addAll(superheroes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
    )

    override fun getItemCount(): Int = villains.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(context, villains[position], clickListener)
    }

    override fun getItemId(position: Int): Long {
        return villains[position].hero.id.hashCode().toLong()
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