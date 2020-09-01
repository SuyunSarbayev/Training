package suyun.example.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import suyun.example.training.databinding.ViewholderRestaurantBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var restaurants: MutableList<Int> = MutableList<Int>(5, {1})
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var binding: ViewholderRestaurantBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.viewholder_restaurant,
            parent,
            false)
        return RestaurantHolder(binding)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RestaurantHolder).bind(restaurants.get(position))
    }
}