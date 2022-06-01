package com.example.kotlin1homework1.ui.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin1homework1.R
import com.example.kotlin1homework1.base.BaseFragment
import com.example.kotlin1homework1.databinding.FragmentFirstBinding
import com.example.kotlin1homework1.model.Model
import com.example.kotlin1homework1.ui.adapter.Adapter
import com.example.kotlin1homework1.ui.fragments.ItemClick

class FirstFragment : BaseFragment<FragmentFirstBinding>() {

    override lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: FirstViewModel
    private val adapter = Adapter()
    private val args: FirstFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        return binding.root
    }

    private fun getData() {
        viewModel.list.add(Model(args.name))
    }

    override fun setupListener() {
        itemClick()
    }

    private fun itemClick() {
        adapter.onClick(object : ItemClick {
            override fun onClick(model: Model) {
                findNavController().navigate(R.id.secondFragment)
            }
        })
    }

    override fun setupViews() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupRequest() {
        viewModel.getList()
        viewModel.liveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
        getData()
    }
}