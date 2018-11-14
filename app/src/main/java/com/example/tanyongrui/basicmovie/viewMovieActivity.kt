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
        p.title = "title of the movie...."
        titleMovie.text = p.title
        Log.e("title of movie", titleMovie.text.toString())
    }


    //val changeTitle: TextView = findViewById(R.id.title) as TextView


}
