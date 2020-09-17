package suyun.example.training.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import suyun.personal.api.Weathers

class SplashViewModel(var splashRepository: SplashRepository) : ViewModel() {

    val weatherLiveData: MutableLiveData<Weathers> = MutableLiveData()

    fun initiateRequestWeather(){
        splashRepository.initiateRequestWeather(weatherLiveData)
    }
}