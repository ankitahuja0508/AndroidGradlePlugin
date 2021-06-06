import org.gradle.api.Action

open class GeneralPluginOptionExtension{
    val retrofit : RetrofitOptions = RetrofitOptions()
    fun retrofit(action: Action<RetrofitOptions>){
        action.execute(retrofit)
    }

    val hilt : HiltOptions = HiltOptions()
    fun hilt(action: Action<HiltOptions>){
        action.execute(hilt)
    }
}

class RetrofitOptions{
    var isEnabled : Boolean = true
}
class HiltOptions{
    var isEnabled : Boolean = true
}