package io.github.felipedavi.eags_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.felipedavi.eags_calculator.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}