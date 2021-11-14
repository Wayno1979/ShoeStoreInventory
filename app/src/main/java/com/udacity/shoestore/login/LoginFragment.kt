package com.udacity.shoestore.login

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        binding.apply {
            viewModel = sharedViewModel

            loginButton.setOnClickListener {
                tryLogin()
            }
            registerButton.setOnClickListener {
                tryLogin()
            }
        }

        return binding.root
    }

    private fun tryLogin() {
        var canLogin = true

        if (binding.emailEditText.text.toString().isEmpty()) {
            binding.emailEditText.error = resources.getString(R.string.email_error)
            canLogin = false
        }

        if (binding.passwordEditText.text.toString().isEmpty()) {
            binding.passwordEditText.error = resources.getString(R.string.password_error)
            canLogin = false
        }

        if (canLogin){
            goToWelcome()
        }
    }

    private fun goToWelcome(){
        sharedViewModel.login()
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }
}