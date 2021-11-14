package com.udacity.shoestore.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var navController: NavController
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, R.layout.shoe_list_fragment, container, false)
        navController = findNavController()

        binding.apply {
            viewModel = sharedViewModel

            fab.setOnClickListener {
                navController.navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
            }
        }

        sharedViewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer {
            addShoes()
        })

        return binding.root
    }

    private fun addShoes() {
        // clear the list
        binding.shoeListLinearLayout.removeAllViews()

        // add a new view for each shoe
        sharedViewModel.shoeList.value?.forEach { shoe ->
            // inflate the shoe item layout
            val shoeBinding: ShoeListItemBinding = inflate(
                layoutInflater,
                R.layout.shoe_list_item,
                binding.shoeListLinearLayout,
                false
            )

            // populate the shoe details
            shoeBinding.apply {
                nameText.text = shoe.name
                shoeCompanyText.text = shoe.company
                shoeSizeText.text = shoe.size.toString()
                descriptionText.text = shoe.description
            }

            binding.shoeListLinearLayout.addView(shoeBinding.root)
        }
    }
}