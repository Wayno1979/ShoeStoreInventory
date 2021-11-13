package com.udacity.shoestore.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

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

        addShoes()

        //todo: add observer for shoes list

        return binding.root
    }

    private fun addShoes() {
        //clear the list
        binding.shoeListLinearLayout.removeAllViews()

        // add a new view for each shoe
        sharedViewModel.shoeList.value?.forEach {
            //todo: create a custom view class that returns shoe layout
//            val shoeBinding = inflate(
//                LayoutInflater.from(context),
//                R.layout.shoe_list_item,
//                binding.shoeListLinearLayout,
//                false
//            )

            //shoeBinding.shoe = it
        }
    }
}