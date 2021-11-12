package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        binding.loginButton.setOnClickListener {
            //todo: extract to viewmodel and xaml
            goToWelcome()
        }

        binding.registerButton.setOnClickListener {
            //todo: extract to viewmodel and xaml
            goToWelcome()
        }

        return binding.root
    }

    fun goToWelcome(){
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }
}