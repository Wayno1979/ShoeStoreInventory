package com.udacity.shoestore.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: ShoeDetailsFragmentBinding
    private lateinit var navController: NavController
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_details_fragment, container, false)
        navController = findNavController()

        binding.apply {
            viewModel = sharedViewModel
            shoe = sharedViewModel.currentShoe.value

            cancelButton.setOnClickListener {
                returnToShoeList()
            }

            sharedViewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer{ shoeAdded ->
                if (shoeAdded) {
                    sharedViewModel.addShoeCompleted()
                    returnToShoeList()
                }
            })
        }

        return binding.root
    }

    private fun returnToShoeList()
    {
        navController.navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
    }
}