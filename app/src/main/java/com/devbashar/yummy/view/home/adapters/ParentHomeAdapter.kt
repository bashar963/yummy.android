package com.devbashar.yummy.view.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devbashar.yummy.databinding.SectionListItemBinding
import com.devbashar.yummy.models.home.Section



class ParentHomeAdapter  constructor(private val context: Context) : RecyclerView.Adapter<ParentHomeAdapter.ParentViewHolder>()
{

    private lateinit var binding: SectionListItemBinding
    private val  viewPool = RecyclerView.RecycledViewPool()
    private val diffCallback = object : DiffUtil.ItemCallback<Section>(){
        override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<Section>) = differ.submitList(list)

    inner class ParentViewHolder(private val binding: SectionListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Section?) {
           item?.let {
               var title:String? = null
               if(!it.title.isNullOrEmpty()){
                   title = it.titleAr
               }
               else if(!it.sectionTitle.isNullOrEmpty()){
                   title = it.sectionTitle
               }
               if(title.isNullOrEmpty()){
                   binding.sectionItemTitle.visibility = View.GONE
               }else{
                   binding.sectionItemTitle.text = title
               }
               if(!it.merchants.isNullOrEmpty()){
                   val childHomeAdapter = ChildHomeAdapter()
                   childHomeAdapter.submitList(it.merchants)
                   val layoutManager1 = if (it.sectionId != "selected_merchant")
                       LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                   else
                       LinearLayoutManager(context)
                   layoutManager1.initialPrefetchItemCount = it.merchants.size
                   viewPool.setMaxRecycledViews(0,0)
                   binding.sectionList.apply {
                       adapter = childHomeAdapter
                       layoutManager = layoutManager1
                      setRecycledViewPool(viewPool)
                   }

               }else{
                  binding.parentSection.visibility = View.GONE
               }
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        binding = SectionListItemBinding.inflate(
            LayoutInflater.from(
            parent.context
        ), parent, false)
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