package com.example.rush

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rush.databinding.ActivityMainBinding
import com.example.rush.databinding.FragmentCartBinding
import com.example.rush.databinding.FragmentHomeBinding


class CartFragment : Fragment() {

    lateinit var cartFragmentBinding: FragmentCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        cartFragmentBinding = FragmentCartBinding.inflate(layoutInflater)

        return cartFragmentBinding.root
    }



























    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}