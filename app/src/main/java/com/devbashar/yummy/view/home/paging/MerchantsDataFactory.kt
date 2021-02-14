package com.devbashar.yummy.view.home.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.devbashar.yummy.data.repository.HomeRepository
import com.devbashar.yummy.models.merchnats.Merchant


class MerchantsDataFactory constructor(private val homeRepository: HomeRepository): DataSource.Factory<Long,Merchant>() {

    private val _mutableLiveData = MutableLiveData<MerchantsDataSource>()
    val mutableLiveData : LiveData<MerchantsDataSource>
        get() = _mutableLiveData
    private lateinit var merchantsDataSource:MerchantsDataSource
    override fun create(): DataSource<Long, Merchant> {
        merchantsDataSource =  MerchantsDataSource(homeRepository)
        _mutableLiveData.postValue(merchantsDataSource)
        return merchantsDataSource
    }
}