package com.example.belajarnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

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

        val num1 = (0..100).random()
        val num2 = (0..100).random()

        txtAngka.text = "$num1 + $num2"

        buttonSubmit.setOnClickListener {
            // Evaluate answer and get score
            val result = num1 + num2
            val answer = editAnswer.text.toString().toInt()
            val score = if (result == answer) 100 else 0

            // Get which action to run
            val action = GameFragmentDirections.actionResultFragment(score)
            // Send action to Navigation.navController
            Navigation.findNavController(it).navigate(action)
        }
    }
}