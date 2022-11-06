package com.example.belajarnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get argument from arguments var
        arguments.let {
            // Get argument from GameFragmentArgs
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtPlayerName.text = "$playerName's turn"
        }

        buttonBack.setOnClickListener {
            // Get which action to run
            val action = GameFragmentDirections.actionMainFragment()
            // Send action to Navigation.navController
            Navigation.findNavController(it).navigate(action)
        }
    }
}