package suyun.example.training.splash

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Response
import suyun.example.training.di.CoroutineProvider
import suyun.personal.api.Api
import suyun.personal.api.Weathers
import kotlin.coroutines.CoroutineContext

class SplashRepository(var api: Api, var coroutineProvider: CoroutineProvider) : CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = coroutineProvider.Main

    fun initiateRequestWeather(weatherLiveData: MutableLiveData<Weathers>){
        launch(coroutineContext) {
            withContext(coroutineProvider.IO, {api.weather("e2a9b7bc30msh709c69b38658668p1dd189jsn7ddbbf2641b2")})?.let {
                result ->
                    if(result.isSuccessful && result.body() != null){
                        weatherLiveData.value = result.body()
                    }
            }

//            val response = api.weather("e2a9b7bc30msh709c69b38658668p1dd189jsn7ddbbf2641b2")
//
//            if (response.isSuccessful && response.body() != null) {
//                weatherLiveData.value = response.body()
//            }
        }
    }
}