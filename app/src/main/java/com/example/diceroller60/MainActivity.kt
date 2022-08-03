package com.example.diceroller60

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


/*
this activity allows the user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        //do a dice roll when app starts
        rollDice()
    }
    //roll the dice and update the result on the screen
    private fun rollDice() {
        //create new dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceroll = dice.roll()
        val diceimage: ImageView = findViewById(R.id.imageView4)
        //determine which drawable resource id to use when dice is rolled
        val drawalbleResource = when(diceroll)
        {
            1 -> R.drawable.dice_1
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }

        //update the resource view with correct drawable resource id
        diceimage.setImageResource(drawalbleResource)
        //update the content description
        diceimage.contentDescription = diceroll.toString()
    }
}

class Dice(val numberofside: Int) {
    fun roll(): Int {
        return (1..numberofside).random()
    }
}
