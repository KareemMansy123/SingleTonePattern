package info.info.singletonepattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import info.info.singletonepattern.model.BaseModel
import info.info.singletonepattern.vm.PostsVM
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var postVm : PostsVM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        postVm = ViewModelProvider(this)[PostsVM::class.java]
        postVm!!.init(this)
    }

    private fun requestPosts(){
        postVm!!.requestPosts()
    }

    private fun responsePosts(){
        postVm!!.responsePosts().observe(this,{
            if (it.isSuccessful){
            // success response
            }else{
                val jObjError = JSONObject(it.errorBody()!!.string())
                val json = Gson().fromJson(jObjError.toString(), BaseModel::class.java)
                // you can log error message here
                // todo
            }
        })
    }
}