package br.com.brunoccbertolini.contries.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.brunoccbertolini.contries.R
import br.com.brunoccbertolini.contries.models.CountriesItem
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.item_country.view.*


class CountriesAdapter: RecyclerView.Adapter<CountriesAdapter.RecyclerViewHolder>() {

   inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    private val differCallBack = object : DiffUtil.ItemCallback<CountriesItem>(){
        override fun areItemsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem.capital == newItem.capital
        }

        override fun areContentsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem == newItem

        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country,
                    parent,
                    false)

        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val country = differ.currentList[position]
        holder.itemView.apply {
            Log.d("svgImage", "URL: ${country.flag}")
            ivCountryFlag.loadSvg(country.flag)
            tvCountryName.text = country.name
            tvCountryCapital.text = country.capital
            tvCountryPopulation.text = country.population.toString()

        }

    }

    fun ImageView.loadSvg(url: String?) {
        GlideToVectorYou
            .init()
            .with(this.context)
            .load(Uri.parse(url), this)
    }


    override fun getItemCount() = differ.currentList.size
}