package com.example.memorygame
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.memorygame.R.drawable.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val images: MutableList<Int> =
            mutableListOf(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6)

        val buttons = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12)

        val cardBalik = 7
        var klik = 0
        var puterBalik = false
        var lastKlik = -1

        images.shuffle()
        for(i in 0..11){
            buttons[i].setBackgroundResource(cardBalik)
            buttons[i].text = "cardBalik"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBalik" && !puterBalik) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (klik == 0) {
                        lastKlik = i
                    }
                    klik++
                } else if (buttons[i].text !in "cardBalik") {
                    buttons[i].setBackgroundResource(cardBalik)
                    buttons[i].text = "cardBalik"
                    klik--
                }

                if (klik == 2) {
                    puterBalik = true
                    if (buttons[i].text == buttons[lastKlik].text) {
                        buttons[i].isClickable = false
                        buttons[lastKlik].isClickable = false
                        puterBalik = false
                        klik = 0
                    }
                } else if (klik == 0) {
                    puterBalik = false
                }
            }
        }

    }

}













