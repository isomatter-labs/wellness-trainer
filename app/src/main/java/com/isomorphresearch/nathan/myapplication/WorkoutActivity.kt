package com.isomorphresearch.nathan.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_workout.*

class WorkoutActivity : AppCompatActivity() {

    private var selectedWorkout: Workout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        selectedWorkout = intent.getSerializableExtra(WORKOUT_KEY) as Workout
        workoutName?.text = selectedWorkout?.name

    }

    companion object {
        //5`
        private val WORKOUT_KEY = "WORKOUT"
    }
}
