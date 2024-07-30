package com.example.tictactoe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicTacToeScreen(
    modifier: Modifier = Modifier,
    viewModel: TicTacToeViewModel = TicTacToeViewModel()
) {
    val state = viewModel.state.value
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val turn = if (state.isXTurn) "X's Turn" else "0's Turn"
        val turnMessage = "Tic Tac Toe \nIt is $turn"
        val winner = state.victor
        val winnerMessage = "Tic Tac Toe \n$winner Wins"
        Text(
            text = if (winner != null) winnerMessage else turnMessage,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(16.dp),
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineMedium
        )



        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            TicTacToeButton(
                state.buttonValues[0],
                state.buttonWinners[0]
            ) { viewModel.setButton(0) }
            TicTacToeButton(
                state.buttonValues[1],
                state.buttonWinners[1]
            ) { viewModel.setButton(1) }
            TicTacToeButton(
                state.buttonValues[2],
                state.buttonWinners[2]
            ) { viewModel.setButton(2) }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            TicTacToeButton(
                state.buttonValues[3],
                state.buttonWinners[3]
            ) { viewModel.setButton(3) }
            TicTacToeButton(
                state.buttonValues[4],
                state.buttonWinners[4]
            ) { viewModel.setButton(4) }
            TicTacToeButton(
                state.buttonValues[5],
                state.buttonWinners[5]
            ) { viewModel.setButton(5) }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            TicTacToeButton(
                state.buttonValues[6],
                state.buttonWinners[6]
            ) { viewModel.setButton(6) }
            TicTacToeButton(
                state.buttonValues[7],
                state.buttonWinners[7]
            ) { viewModel.setButton(7) }
            TicTacToeButton(
                state.buttonValues[8],
                state.buttonWinners[8]
            ) { viewModel.setButton(8) }
        }
        Button(onClick = { viewModel.resetBoard() }, ) {
            Text(text = "Reset Game", fontSize = 50.sp)

        }
    }
}

@Composable
fun TicTacToeButton (
    button: String,
    shouldChangeColor: Boolean,
    onClick: () -> Unit,
){
    val color = if(shouldChangeColor) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        )) {
        Text(text = button, fontSize = 50.sp)
    }
}