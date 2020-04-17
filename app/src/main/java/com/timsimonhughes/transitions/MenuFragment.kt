package com.timsimonhughes.transitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController(requireActivity(), R.id.nav_host_fragment)

        button_1.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_fragment1)
        }

        button_2.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_fragment2)
        }

        button_3.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_fragment3)
        }
    }

}
