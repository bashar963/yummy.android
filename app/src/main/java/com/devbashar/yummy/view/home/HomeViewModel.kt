package com.devbashar.yummy.view.home

import androidx.arch.core.util.Function
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.devbashar.yummy.data.repository.HomeRepository
import com.devbashar.yummy.models.CuisinResponse
import com.devbashar.yummy.models.home.HomeResponse
import com.devbashar.yummy.models.merchnats.Merchant
import com.devbashar.yummy.models.merchnats.MerchantsResponse
import com.devbashar.yummy.utils.Resource
import com.devbashar.yummy.view.home.paging.MerchantsDataFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
     private val homeRepository: HomeRepository
): ViewModel() {
     private val _homeData = MutableLiveData<Resource<HomeResponse>>()

     val homeData : LiveData<Resource<HomeResponse>>
          get() = _homeData


     private val _cuisineData = MutableLiveData<Resource<CuisinResponse>>()

     val cuisineData : LiveData<Resource<CuisinResponse>>
          get() = _cuisineData

     private val _merchantsData = MutableLiveData<PagedList<Merchant>>()

     lateinit var merchantsData : LiveData<PagedList<Merchant>>
         // get() = _merchantsData

     private var _merchantsNetworkState = MutableLiveData<Resource<MerchantsResponse>>()

      lateinit var merchantsNetworkState : LiveData<Resource<MerchantsResponse>>
         // get() = _merchantsNetworkState

     private val executor: Executor = Executors.newFixedThreadPool(5)

     init {
          getHome()
          getCuisines()
          getMerchants()
     }

     private fun getMerchants() {
        val merchantsDataFactory = MerchantsDataFactory(homeRepository)

          merchantsNetworkState = Transformations.switchMap(merchantsDataFactory.mutableLiveData) { dataSource -> dataSource.merchantData }
          val pagedListConfig =
          ( PagedList.Config.Builder())
               .setEnablePlaceholders(false)
               .setInitialLoadSizeHint(10)
               .setPageSize(20).build()
          merchantsData = ( LivePagedListBuilder(merchantsDataFactory, pagedListConfig))
               .setFetchExecutor(executor)
               .build()
     }

     private fun getCuisines()  = viewModelScope.launch {
          _cuisineData.postValue(Resource.loading(null))
          homeRepository.getCuisines().let {
               if (it.isSuccessful){
                    _cuisineData.postValue(Resource.success(it.body()))
               }else{
                    _cuisineData.postValue(Resource.error(it.errorBody().toString(), null))
               }
          }
     }

     private fun getHome()  = viewModelScope.launch {
          _homeData.postValue(Resource.loading(null))
          homeRepository.getHome().let {
               if (it.isSuccessful){
                    _homeData.postValue(Resource.success(it.body()))
               }else{
                    _homeData.postValue(Resource.error(it.errorBody().toString(), null))
               }
          }
     }
}