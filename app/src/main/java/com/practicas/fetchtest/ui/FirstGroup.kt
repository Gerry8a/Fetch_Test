package com.practicas.fetchtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.databinding.FragmentFirstGroupBinding
import com.practicas.fetchtest.model.RandomObject
import com.practicas.fetchtest.ui.adapters.ObjectAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstGroup : Fragment() {

    private lateinit var binding: FragmentFirstGroupBinding
    private val viewModel: RandomViewModel by viewModels()
    private val randomList = ArrayList<RandomObject>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstGroupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemList.observe(requireActivity()) {
            when (it) {
                is ApiResponseStatus.Error -> Toast.makeText(
                    requireContext(),
                    it.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()

                is ApiResponseStatus.Loading -> {}
                is ApiResponseStatus.Success -> {
                    it.let {
                        for (randomObject in it.data) {
                            fillUI(randomObject)
                            viewModel.insertObject(randomObject)
                        }
                    }

                }
            }
        }
    }

    private fun fillUI(randomObject: RandomObject) {
//        val manager = GridLayoutManager(requireContext(), GRID_SPA)
        randomList.add(randomObject)
        binding.rvList.adapter = ObjectAdapter(randomList) {}
        binding.rvList.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.rvList.setHasFixedSize(true)
    }


}