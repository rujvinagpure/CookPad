package com.example.cookpad

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.concurrent.Flow

class ApiProvider {

    private val TAG = "ApiProvider"

    private val mApiServiceNetwork = ApiServiceNetwork.getInstance()

    fun callApi(apiResult: ApiResult) {
        try {
            mApiServiceNetwork.getNetworkService(Constants.API_ENDPOINT)
                .getSampleData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(@RequiresApi(Build.VERSION_CODES.R)
                object : Flow.Subscriber<SampleGetModel>( ) {
                    fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "onError" + Log.getStackTraceString(e))
                        apiResult.onAPIFail()
                    }

                    override fun onNext(sampleGetModel: SampleGetModel) {
                        Log.i(TAG, "Operation performed successfully")
                        apiResult.onModel(SampleGetModel)
                    }

                    override fun onComplete() {
                        TODO("Not yet implemented")
                    }

                    override fun onSubscribe(p0: Flow.Subscription?) {
                        TODO("Not yet implemented")
                    }
                })
        } catch (e: Exception) {
            Log.e(TAG, "Exception" + Log.getStackTraceString(e))
            apiResult.onError(e)
        }

    }
}