package com.example.tanyongrui.basicmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_movie.*

class viewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)

        val p = movieEntity()
        //p.title = "title of the movie...."
        titleMovieText.text = p.title
        overviewText.text = p.overview
        languageText.text = p.language
        releaseDateText.text = p.releaseDate
        if (p.suitableAge == true) {
            suitableAgeText.text = "Yes"
        }
        else{
            suitableAgeText.text = "No"
        }
        Log.e("title of movie", titleMovieText.text.toString())
        Log.e("overview of movie ", overviewText.text.toString())
        Log.e("language used ", languageText.text.toString())
        Log.e("release date", releaseDate.text.toString())
        Log.e("suitable age", suitableAgeText.text.toString())
    }


    //val changeTitle: TextView = findViewById(R.id.title) as TextView


}
