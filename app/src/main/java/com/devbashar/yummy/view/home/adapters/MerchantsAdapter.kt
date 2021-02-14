package com.devbashar.yummy.view.home.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbashar.yummy.databinding.MerchantItemBinding

import com.devbashar.yummy.models.merchnats.Merchant
import com.devbashar.yummy.utils.Constants

class MerchantsAdapter : PagedListAdapter<Merchant, MerchantsAdapter.MerchantViewHolder>(diffCallback) {

    private lateinit var binding: MerchantItemBinding
    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<Merchant>(){
            override fun areItemsTheSame(oldItem: Merchant, newItem: Merchant): Boolean {
                return oldItem.merchantId == newItem.merchantId
            }

            override fun areContentsTheSame(oldItem: Merchant, newItem: Merchant): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

    inner class MerchantViewHolder(private val binding: MerchantItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Merchant?) {
            item?.let {
                binding.root.setOnClickListener {

                }
                var image ="https://yummy-app.com/upload/1547273563-app-icon.png"
                if(!it.merchantPhotoBg.isNullOrEmpty()) {
                    image = if (it.merchantPhotoBg.contains("upload")) {
                        Constants.BASE_URL + it.merchantPhotoBg
                    } else {
                        Constants.BASE_URL + "/upload/" + it.merchantPhotoBg
                    }
                }
                Glide.with(binding.root).load(image).into(binding.merchantImage)
                binding.merchantTitle.text = it.restaurantNameAr
                binding.rating.text = it.averageRating.toString()
                binding.ratingCount.text =  "${it.totalRating.toString()} تقييم"
                binding.cuisines.text = it.cuisine
                binding.deliverFee1.text = it.averageDeliveryCharge.toString()
                binding.distance .text = "${it.distance} كم"

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantViewHolder {
        binding = MerchantItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return MerchantViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MerchantViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}