package com.example.rush

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.MediaController
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rush.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


   // private lateinit var  navController: NavController
    //private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentHostView)
        //navController = findNavController(R.id.fragmentHostView)
        val navController = navHostFragment?.findNavController()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        if (navController != null) {
            bottomNavigationView.setupWithNavController(navController)
        }


        val homeFragment = HomeFragment()
        val cartFragment = CartFragment()

//        binding.bottomNavigation.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.home_page -> setCurrentFragment(homeFragment)
//                R.id.cart_page -> setCurrentFragment(cartFragment)
//            }
//            true
//        }


    }

    private fun setCurrentFragment(fragment: Fragment) =  supportFragmentManager.beginTransaction().apply {

        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN )

        replace(R.id.fragmentHostView,fragment)
        commit()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }


}