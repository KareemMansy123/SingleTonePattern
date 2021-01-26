package info.info.singletonepattern.model

class BaseModel : ArrayList<BaseModelItem>()

data class BaseModelItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)