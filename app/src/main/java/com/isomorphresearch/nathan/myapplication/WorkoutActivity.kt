package com.isomorphresearch.nathan.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.app_bar_workout.*

class WorkoutActivity : AppCompatActivity() {

    private var selectedWorkout: Workout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_workout)

        selectedWorkout = intent.getSerializableExtra(WORKOUT_KEY) as Workout

        fab1.setOnClickListener { view ->
            Snackbar.make(view, "Do it yourself!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }



    companion object {
        //5`
        private val WORKOUT_KEY = "WORKOUT"
    }
}
