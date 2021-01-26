package info.info.singletonepattern.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.info.singletonepattern.model.BaseModel
import info.info.singletonepattern.repos.GetPostsRepo
import retrofit2.Response

class PostsVM : ViewModel() {
    private var baseResponse = MutableLiveData<Response<List<BaseModel>>>()
    lateinit var owner: LifecycleOwner

    fun init(owner: LifecycleOwner) {
        this.owner = owner
    }

    fun requestPosts(){
        GetPostsRepo.getPostsRepo().observe(owner,{
            baseResponse.postValue(it)
        })
    }

    fun responsePosts() :MutableLiveData<Response<List<BaseModel>>>{
        return baseResponse
    }
}