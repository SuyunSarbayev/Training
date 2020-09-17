package suyun.example.training.di

import android.content.Context
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import suyun.example.training.splash.SplashViewModel
import suyun.example.training.splash.SplashRepository
import java.util.concurrent.TimeUnit
import suyun.personal.api.Api
import kotlin.coroutines.CoroutineContext

val applicationModule: Module = module {
    factory { initializeOkhttpClient(get()) }
    factory<CoroutineContext>(named("io")) { Dispatchers.IO }
    factory<CoroutineContext>(named("main")) { Dispatchers.Main }
    single { CoroutineProvider() }
    single {
        initializeAPI(
            get(),
            "https://community-open-weather-map.p.rapidapi.com/"
        )
    }
}

class CoroutineProvider : KoinComponent {
    val Main: CoroutineContext by inject(named("main"))
    val IO: CoroutineContext by inject(named("io"))
}

val viewModelModule: Module = module {
    viewModel { SplashViewModel(get()) }
}

val repositoryModule: Module = module {
    factory { SplashRepository(get(), get()) }
}

fun initializeAPI(okHttpClient: OkHttpClient, url: String) : Api{
    return initializeAPIService<Api>(okHttpClient, url)
}

fun initializeOkhttpClient(context: Context) : OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(30000, TimeUnit.MILLISECONDS)
        .readTimeout(30000, TimeUnit.MILLISECONDS)
        .build()
}

inline fun <reified T> initializeAPIService(okHttpClient: OkHttpClient, baseUrl: String) : T =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
