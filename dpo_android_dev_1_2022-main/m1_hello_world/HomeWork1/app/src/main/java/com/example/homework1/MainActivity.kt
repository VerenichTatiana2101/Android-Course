package com.example.homework1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val COUNT_PASSENGER: Int = 50
    }

    private var cnt: Int = 0
    private var cntPlaces = COUNT_PASSENGER


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) //добавили
        setContentView(binding.root)
        binding.reduceView.isEnabled = false //состояние пустого

        binding.reduceView.setOnClickListener {
            binding.helloView.setTextColor(Color.BLUE)
            binding.addView.isEnabled = true
            binding.restartView.visibility = View.INVISIBLE
            cnt-- // reduceCounter
            binding.counterView.text = cnt.toString()
            cntPlaces++
            binding.helloView.text = getString(R.string.noEmpty) + " " + cntPlaces
            if (cnt <= 0) {
                binding.reduceView.isEnabled = false  //состояние пустого
                binding.helloView.setTextColor(Color.GREEN)
                binding.helloView.text = getString(R.string.empty)
            } else binding.reduceView.isEnabled = true
        }


        binding.addView.setOnClickListener{
            binding.reduceView.isEnabled = true
            binding.helloView.setTextColor(Color.BLUE)
            cnt++
            binding.counterView.text = cnt.toString()
            cntPlaces--
            binding.helloView.text = getString(R.string.noEmpty) + " " + cntPlaces
            if (cntPlaces <= 0) {   //fullCounter
                binding.helloView.text = getString(R.string.full)
                binding.helloView.setTextColor(Color.RED)
                binding.restartView.visibility = View.VISIBLE
                binding.addView.isEnabled = false
            }
        }

        binding.restartView.setOnClickListener{
            cnt = 0  //emptyCounter
            cntPlaces = COUNT_PASSENGER
            binding.helloView.setTextColor(Color.GREEN)
            binding.restartView.visibility = View.INVISIBLE
            binding.helloView.text = getString(R.string.empty)
            binding.counterView.text = cnt.toString()
            binding.reduceView.isEnabled = false
        }
    }
}
