package suyun.example.training.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import suyun.example.training.R
import suyun.example.training.databinding.FragmentMainBinding
import suyun.personal.api.Weathers

class SplashFragment : Fragment() {

    val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val binding: FragmentMainBinding = DataBindingUtil
            .inflate(inflater,
                R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer<Weathers>{
            Log.d("CHANGED", it.toString())
        })
        viewModel.initiateRequestWeather()
        Log.d("CHANGED", "1")
        Log.d("CHANGED", "2")
        Log.d("CHANGED", "3")
        Log.d("CHANGED", "4")
        Log.d("CHANGED", "5")
        Log.d("CHANGED", "6")
        Log.d("CHANGED", "7")
        Log.d("CHANGED", "8")
        Log.d("CHANGED", "9")
        Log.d("CHANGED", "10")
        Log.d("CHANGED", "11")
        Log.d("CHANGED", "12")
        Log.d("CHANGED", "13")
        Log.d("CHANGED", "14")
        Log.d("CHANGED", "15")
    }
}

