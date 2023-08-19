package com.practicas.fetchtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.practicas.fetchtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.model.RandomObject
import com.practicas.fetchtest.ui.adapters.ObjectAdapter
import java.util.Random


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RandomViewModel by viewModels()
    private val randomList = ArrayList<RandomObject>()

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
                is ApiResponseStatus.Success ->{
                    for (randomObject in it.data){
                        fillUI(randomObject)
                    }
                }
            }
        }
    }

    private fun fillUI(randomObject: RandomObject) {
        val manager = LinearLayoutManager(this)
        randomList.add(randomObject)
        binding.rvList.adapter = ObjectAdapter(randomList){}
        binding.rvList.layoutManager = manager
        binding.rvList.setHasFixedSize(true)
    }
}