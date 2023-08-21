package com.practicas.fetchtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.practicas.fetchtest.R
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.databinding.FragmentFourthGroupBinding
import com.practicas.fetchtest.model.RandomObject
import com.practicas.fetchtest.ui.adapters.ObjectAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FourthGroup : Fragment() {

    private lateinit var binding: FragmentFourthGroupBinding
    private val viewModel: RandomViewModel by viewModels()
    private val randomList = ArrayList<RandomObject>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourthGroupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildObservers()
    }

    private fun buildObservers() {
        viewModel.getRandomList(4)
        viewModel.itemList.observe(requireActivity()) {
            when (it) {
                is ApiResponseStatus.Error -> {
                    binding.loading.root.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        it.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is ApiResponseStatus.Loading -> {}
                is ApiResponseStatus.Success -> {
                    binding.loading.root.visibility = View.GONE
                    it.let {
                        for (randomObject in it.data) {
                            fillUI(randomObject)
                        }
                    }
                }
            }
        }
    }

    private fun fillUI(randomObject: RandomObject) {
        randomList.add(randomObject)
        binding.rvList.adapter = ObjectAdapter(randomList) {}
        binding.rvList.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.rvList.setHasFixedSize(true)
    }
}

