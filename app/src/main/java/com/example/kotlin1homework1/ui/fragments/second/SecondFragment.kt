package com.example.kotlin1homework1.ui.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin1homework1.R
import com.example.kotlin1homework1.base.BaseFragment
import com.example.kotlin1homework1.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun setupListener() {
        binding.button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", binding.edit.text.toString())
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                "key",
                bundle
            )
            findNavController().navigateUp()
        }
    }
}