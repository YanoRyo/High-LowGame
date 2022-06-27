package com.example.highandlow

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val tag = "high and low"
    private var yourCard = 0
    private var droiCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hightBtn:Button = findViewById(R.id.highBtn)
        var lowBtn:Button = findViewById(R.id.lowBtn)
        var nextBtn:Button = findViewById(R.id.nextBtn)

        hightBtn.setOnClickListener {
            if((gameStart && !answered)){
                highAndLow('h')
            }
        }
        lowBtn.setOnClickListener {
            if((gameStart && !answered)){
                highAndLow('l')
            }
        }
        nextBtn.setOnClickListener {
            if(gameStart){
                drawCard()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0
        var hitText:TextView = findViewById(R.id.hitText)
        var loseText:TextView = findViewById(R.id.loseText)
        hitText.text = getString(R.string.hit_Text)
        loseText.text = getString(R.string.lose_Text)
        gameStart = true
        drawCard()
    }
    private fun drawCard(){
        var yourCardImage: ImageView = findViewById(R.id.yourCardImage)
        var droidCardImage: ImageView = findViewById(R.id.droidCardImage)
        yourCardImage.setImageResource(R.drawable.z02)
        droidCardImage.setImageResource(R.drawable.z02)
//        IntRange.random()で乱数を生成
        yourCard = (1..13).random()
        Log.d(tag,"You:"+yourCard)
        when(yourCard){
            1 -> yourCardImage.setImageResource(R.drawable.d01)
            2 -> yourCardImage.setImageResource(R.drawable.d02)
            3 -> yourCardImage.setImageResource(R.drawable.d03)
            4 -> yourCardImage.setImageResource(R.drawable.d04)
            5 -> yourCardImage.setImageResource(R.drawable.d05)
            6 -> yourCardImage.setImageResource(R.drawable.d06)
            7 -> yourCardImage.setImageResource(R.drawable.d07)
            8 -> yourCardImage.setImageResource(R.drawable.d08)
            9 -> yourCardImage.setImageResource(R.drawable.d09)
            10 -> yourCardImage.setImageResource(R.drawable.d10)
            11 -> yourCardImage.setImageResource(R.drawable.d11)
            12 -> yourCardImage.setImageResource(R.drawable.d12)
            13 -> yourCardImage.setImageResource(R.drawable.d13)
        }
        droiCard = (1..13).random()
        Log.d(tag,"droid:"+droiCard)
        answered = false
    }
    private fun highAndLow(answer:Char){
        showDroidCard()
        answered = true
        var hitText:TextView = findViewById(R.id.hitText)
        var loseText:TextView = findViewById(R.id.loseText)
        if (hitCount == 5){
            var resultText:TextView = findViewById(R.id.resultText)
            resultText.text = ""
        }else{
            var resultText:TextView = findViewById(R.id.resultText)
            resultText.text = ""
        }

        val balance = droiCard - yourCard
        if (balance == 0){
//            when even do nothing
        }else if ((balance > 0 && answer == 'h')){
            hitCount++
            hitText.text = getString(R.string.hit_Text) + hitCount
        }else if ((balance < 0 && answer == 'l')){
            hitCount++
            hitText.text = getString(R.string.hit_Text) + hitCount
        }else {
            loseCount++
            loseText.text = getString(R.string.lose_Text) + loseCount
        }
        if (hitCount == 5){
            var resultText:TextView = findViewById(R.id.resultText)
            resultText.text = "あなたの勝ちです！"
            hitCount = 0
            loseCount = 0
            gameStart = true
        }else if (loseCount == 5){
            var resultText:TextView = findViewById(R.id.resultText)
            resultText.text = "あなたの負けです！"
            hitCount = 0
            loseCount = 0
            gameStart = true
        }else {
//            do nothing
        }
    }
    private fun showDroidCard(){
        var droidCardImage: ImageView = findViewById(R.id.droidCardImage)
        when (droiCard){
            1 -> droidCardImage.setImageResource(R.drawable.c01)
            2 -> droidCardImage.setImageResource(R.drawable.c02)
            3 -> droidCardImage.setImageResource(R.drawable.c03)
            4 -> droidCardImage.setImageResource(R.drawable.c04)
            5 -> droidCardImage.setImageResource(R.drawable.c05)
            6 -> droidCardImage.setImageResource(R.drawable.c06)
            7 -> droidCardImage.setImageResource(R.drawable.c07)
            8 -> droidCardImage.setImageResource(R.drawable.c08)
            9 -> droidCardImage.setImageResource(R.drawable.c09)
            10 -> droidCardImage.setImageResource(R.drawable.c10)
            11 -> droidCardImage.setImageResource(R.drawable.c11)
            12 -> droidCardImage.setImageResource(R.drawable.c12)
            13 -> droidCardImage.setImageResource(R.drawable.c13)
        }
    }
}