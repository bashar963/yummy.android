package com.devbashar.yummy.view.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devbashar.yummy.databinding.MerchantItemBinding
import com.devbashar.yummy.models.home.Merchant
import com.devbashar.yummy.utils.Constants.BASE_URL


class ChildHomeAdapter : RecyclerView.Adapter<ChildHomeAdapter.ParentViewHolder>()
{

    private lateinit var binding: MerchantItemBinding
    private val diffCallback = object : DiffUtil.ItemCallback<Merchant>(){
        override fun areItemsTheSame(oldItem: Merchant, newItem: Merchant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Merchant, newItem: Merchant): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<Merchant>) = differ.submitList(list)

    inner class ParentViewHolder(private val binding: MerchantItemBinding): RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bind(item: Merchant?) {
            item?.let {
                binding.root.setOnClickListener {

                }
                var image ="https://yummy-app.com/upload/1547273563-app-icon.png"
                if(!it.imagePath.isNullOrEmpty()){
                    image = BASE_URL +it.imagePath
                    binding.dataHolder.visibility = View.GONE
                }else if(!it.merchantPhotoBg.isNullOrEmpty()){
                    image = if(it.merchantPhotoBg.contains("upload")){
                        BASE_URL + it.merchantPhotoBg
                    }else{
                        BASE_URL  + "/upload/" + it.merchantPhotoBg
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        binding = MerchantItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return ParentViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = differ.currentList.size
}