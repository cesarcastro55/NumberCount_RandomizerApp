package com.example.myapplication.ui.random_number

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRandomNumberBinding

class RandomNumberFragment : Fragment() {

    private lateinit var binding: FragmentRandomNumberBinding

    private val viewModel: RandomNumberFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_random_number, container, false)
        return binding.root

    }

    private val args: RandomNumberFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomNumberViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.previousButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val count = args.countArg
        val countText = getString(R.string.random_heading, count)
        binding.textviewHeader.text = countText


        binding.generateButton.setOnClickListener {
            viewModel.random(count)
        }
    }
}