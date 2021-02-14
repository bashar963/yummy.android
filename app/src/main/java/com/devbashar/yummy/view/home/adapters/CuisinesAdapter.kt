package com.devbashar.yummy.view.home.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbashar.yummy.databinding.CuisineItemBinding
import com.devbashar.yummy.models.Cusisine
import com.devbashar.yummy.utils.Constants.BASE_URL


class CuisinesAdapter: RecyclerView.Adapter<CuisinesAdapter.CuisineViewHolder>() {

    inner class CuisineViewHolder(private val binding: CuisineItemBinding):RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Cusisine?) {
            item?.let {
                binding.root.setOnClickListener {

                }
                binding.cuisineName.text = it.cuisineName
                Glide.with(binding.root).load(BASE_URL+it.image).into(binding.cuisineImage)
            }
        }
    }

    private lateinit var binding: CuisineItemBinding
    private val diffCallback = object : DiffUtil.ItemCallback<Cusisine>(){
        override fun areItemsTheSame(oldItem: Cusisine, newItem: Cusisine): Boolean {
            return oldItem.cuisineID == newItem.cuisineID
        }

        override fun areContentsTheSame(oldItem: Cusisine, newItem: Cusisine): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<Cusisine>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuisineViewHolder {
        binding = CuisineItemBinding.inflate(LayoutInflater.from(
                parent.context
        ), parent, false)
        return CuisineViewHolder(
                binding
        )
    }


    override fun onBindViewHolder(holder: CuisineViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = differ.currentList.size
}