package com.devbashar.yummy.view.home.paging

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.devbashar.yummy.data.repository.HomeRepository
import com.devbashar.yummy.models.merchnats.Merchant
import com.devbashar.yummy.models.merchnats.MerchantsResponse
import com.devbashar.yummy.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


class MerchantsDataSource  constructor(private val homeRepository: HomeRepository) : PageKeyedDataSource<Long, Merchant>() {

    companion object{
        private val  TAG: String = MerchantsDataSource::class.java.simpleName
    }

    private val _merchantData = MutableLiveData<Resource<MerchantsResponse>>()
    val merchantData : LiveData<Resource<MerchantsResponse>>
        get() = _merchantData

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Merchant>
    ) {
        _merchantData.postValue(Resource.loading(null))
        CoroutineScope(Dispatchers.IO).launch {
            homeRepository.getMerchants(1).let {
                if (it.isSuccessful){
                    _merchantData.postValue(Resource.success(it.body()))
                    it.body()?.let {a->
                        if(!a.data.isNullOrEmpty())
                            callback.onResult(a.data, null, 2)
                        else
                            callback.onResult(listOf(), null, null)
                    }

                }else{
                    _merchantData.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Merchant>) {

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Merchant>) {
        Log.i(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize)
        _merchantData.postValue(Resource.loading(null))
        CoroutineScope(Dispatchers.IO).launch {
            homeRepository.getMerchants(params.key.toInt()).let {
                if (it.isSuccessful){
                    var pageCounts = 1
                    _merchantData.postValue(Resource.success(it.body()))
                    it.body()?.let {a->
                        pageCounts = (a.total!!.toDouble()/a.perPage!!.toDouble()).roundToInt()
                        Log.i(TAG, a.perPage .toString())
                        Log.i(TAG,a.total  .toString())
                        Log.i(TAG,(a.total.toDouble() / a.perPage.toDouble() ).toString())
                        Log.i(TAG, pageCounts.toString())
                        var  nextKey:Long? = null
                        if(params.key <= pageCounts)
                            nextKey = params.key+1

                        if(!a.data.isNullOrEmpty())
                            callback.onResult(a.data,  nextKey)
                        else
                            callback.onResult(listOf(),  null)
                    }

                }else{
                    _merchantData.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}