package com.example.adv160420016week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get argument from arguments var
        arguments.let {
            // Get argument from GameFragmentArgs
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScore.text = "Your score is $playerScore"
        }

        buttonBack.setOnClickListener {
            // Get which action to run
            val action = ResultFragmentDirections.actionMainFragment()
            // Send action to Navigation.navController
            Navigation.findNavController(it).navigate(action)
        }
    }
}