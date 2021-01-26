package info.info.singletonepattern.networkInterFace

import info.info.singletonepattern.model.BaseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts() : Response<List<BaseModel>>
}