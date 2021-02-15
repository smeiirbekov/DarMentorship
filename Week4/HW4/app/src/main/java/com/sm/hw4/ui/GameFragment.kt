package com.sm.hw4.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.forEachIndexed
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sm.hw4.R
import com.sm.hw4.data.*
import com.sm.hw4.databinding.FragmentGameBinding
import com.sm.hw4.utils.BindingFragment

private const val GAME_STATE_ARG = "game_state"

class GameFragment: BindingFragment<FragmentGameBinding>(FragmentGameBinding::inflate) {

    private val repository = UsersRepository
    private val args: GameFragmentArgs by navArgs()
    private lateinit var game: TicTacToeGame

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        game = savedInstanceState?.getSerializable(GAME_STATE_ARG)?.let {
            @Suppress("UNCHECKED_CAST")
            TicTacToeGame(it as Array<CharArray>)
        } ?: TicTacToeGame()

        binding.vgTttBoard.forEachIndexed { i, vg ->
            (vg as ViewGroup).forEachIndexed { j, iv ->
                updateView(i, j, iv as ImageView)
                iv.setOnClickListener {
                    game.moveAt(i, j)
                    updateView(i, j, iv)
                }
            }
        }

        game.onGameEnd = { end, line ->
            when(end) {
                GameEnd.X_WON -> binding.tvInfo.text = "${args.userX} Won"
                GameEnd.O_WON -> binding.tvInfo.text = "${args.userO} Won"
                GameEnd.DRAW -> binding.tvInfo.text = "Draw"
            }
            line?.forEach {
                updateView(it.first, it.second, (binding.vgTttBoard.getChildAt(it.first) as ViewGroup).getChildAt(it.second) as ImageView, true)
            }
            binding.btnContinue.visibility = View.VISIBLE
            binding.btnContinue.setOnClickListener {
                repository.addWinner(if (end == GameEnd.X_WON) args.userX else args.userO)
                repository.addLoser(if (end == GameEnd.O_WON) args.userX else args.userO)
                findNavController().navigate(GameFragmentDirections.actionGameToRecords())
            }
        }
    }

    private fun updateView(i:Int, j:Int, iv: ImageView, winning: Boolean = false){
        when(game.state[i][j]) {
            X -> iv.setImageResource(R.drawable.ic_baseline_close_24)
            O -> iv.setImageResource(R.drawable.ic_baseline_panorama_fish_eye_24)
            else -> iv.setImageResource(android.R.color.transparent)
        }
        if (winning)
            iv.setBackgroundResource(R.drawable.bg_box_won)
        else if (!game.gameOver)
            binding.tvInfo.text = "${if (game.isXTurn()) "${args.userX}'s" else "${args.userO}'s"} turn"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(GAME_STATE_ARG, game.state)
    }
}