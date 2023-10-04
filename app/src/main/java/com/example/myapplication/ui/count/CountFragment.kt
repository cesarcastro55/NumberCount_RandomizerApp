package com.example.myapplication.ui.count

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCountBinding

class CountFragment : Fragment() {

    private lateinit var binding: FragmentCountBinding

    private val viewModel: CountFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_count, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        binding.randomButton.setOnClickListener {
            val currentCount = viewModel.currentCount.value.toString().toInt()
            val action = CountFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast!!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        binding.countButton.setOnClickListener {
            viewModel.countMe()
        }
    }

}