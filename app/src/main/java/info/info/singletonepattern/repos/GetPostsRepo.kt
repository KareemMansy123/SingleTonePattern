package info.info.singletonepattern.repos

import android.util.Log
import androidx.lifecycle.LiveData
import com.adm.freejna.versionfreejna.presentation.pojo.network.RetrofitBuilder
import info.info.singletonepattern.model.BaseModel
import kotlinx.coroutines.*
import retrofit2.Response

object GetPostsRepo {
    var job: CompletableJob? = null

    fun getPostsRepo(): LiveData<Response<List<BaseModel>>> {
        job = Job()
        return object : LiveData<Response<List<BaseModel>>>() {
            override fun onActive() {
                super.onActive()
                job?.let { thejob ->
                    CoroutineScope(Dispatchers.IO + thejob).launch {
                        val response = RetrofitBuilder.apiService.getPosts()
                        withContext(Dispatchers.Main) {
                            try {
                                value = response
                                thejob.complete()
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                                Log.d("debugL::", ex.message.toString())
                            }
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job!!.cancel()
    }
}