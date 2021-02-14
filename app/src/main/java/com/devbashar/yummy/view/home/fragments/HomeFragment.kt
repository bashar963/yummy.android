package com.devbashar.yummy.view.home.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.devbashar.yummy.databinding.HomeFragmentBinding
import com.devbashar.yummy.models.Cusisine
import com.devbashar.yummy.models.home.Section
import com.devbashar.yummy.utils.Status
import com.devbashar.yummy.view.home.HomeViewModel
import com.devbashar.yummy.view.home.adapters.CuisinesAdapter
import com.devbashar.yummy.view.home.adapters.MerchantsAdapter
import com.devbashar.yummy.view.home.adapters.ParentHomeAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var cuisinesAdapter: CuisinesAdapter
    private lateinit var homeDataAdapter: ParentHomeAdapter
    private lateinit var merchantsAdapter: MerchantsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initCuisineList()
        initHomeList()
        initMerchants()

    }

    private fun initMerchants() {
        merchantsAdapter = MerchantsAdapter()
        binding.merchantsList.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
            adapter = merchantsAdapter
        }
        homeViewModel.merchantsData.observe(viewLifecycleOwner,{
            merchantsAdapter.submitList(it)
        })
    }

    private fun initHomeList() {
        homeDataAdapter = ParentHomeAdapter(this.requireContext())
         val  viewPool = RecyclerView.RecycledViewPool()
        viewPool.setMaxRecycledViews(0,0)
        binding.parentHomeList.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
            adapter = homeDataAdapter
            setRecycledViewPool(viewPool)
        }
        homeViewModel.homeData.observe(viewLifecycleOwner,  {
            when(it.status){
                Status.SUCCESS -> {
                    it.data?.let {res->
                        if (res.status == "success"){
                            res.data?.let {
                                val list = mutableListOf<Section>()
                                res.data.forEach { section->
                                    if(!section.merchants.isNullOrEmpty())
                                        list.add(section)
                                }
                                homeDataAdapter.submitList(list)
                            }
                        }else{
                            Snackbar.make(this.requireView(), "Status = false",Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        })

    }

    private fun initCuisineList() {
        cuisinesAdapter = CuisinesAdapter()
        binding.cuisinesList.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = cuisinesAdapter
        }
        homeViewModel.cuisineData.observe(viewLifecycleOwner,  {
            when(it.status){
                Status.SUCCESS -> {
                    it.data?.let {res->
                        if (res.code == 1){
                            val list = mutableListOf<Cusisine>()
                            res.details.forEach { details ->
                                list.add(details.cusisine)
                            }
                            cuisinesAdapter.submitList(list)
                        }else{
                            Snackbar.make(this.requireView(), "Status = false",Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        })
    }

}