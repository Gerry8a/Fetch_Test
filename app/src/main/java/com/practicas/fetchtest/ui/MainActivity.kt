package com.practicas.fetchtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.practicas.fetchtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.practicas.fetchtest.data.remote.response.ApiResponseStatus


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RandomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buildObservers()
    }

    private fun buildObservers() {
        viewModel.itemList.observe(this@MainActivity){
            when(it){
                is ApiResponseStatus.Error -> Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                is ApiResponseStatus.Loading -> {}
                is ApiResponseStatus.Success -> Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()
            }
        }
    }
}