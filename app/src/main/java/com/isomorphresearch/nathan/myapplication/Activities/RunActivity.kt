package com.isomorphresearch.nathan.myapplication.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.R
import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.isomorphresearch.nathan.myapplication.Classes.Exercise
import com.isomorphresearch.nathan.myapplication.Classes.Workout
import com.isomorphresearch.nathan.myapplication.IsoApp
import kotlinx.android.synthetic.main.activity_run.*
import kotlinx.android.synthetic.main.dialog_add_name.view.*


class RunActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.isomorphresearch.nathan.myapplication.R.layout.activity_run)
        val workout = intent.getSerializableExtra("RUN") as Workout

        Log.e("NATHAN1", "onCreate Top")


        Log.e("NATHAN1", workout.exercises.size.toString())


        runExercise(workout, 0, textView6, textView3)


        /*
            async is happening now
            tasks are being pushed to the background and running at the same time
            Trying to see if they can hang up until they get to onFinish
         */

        } // last exercise has no cooldown after and makes alert message

    fun runExercise(wk: Workout, index: Int, time: TextView, title: TextView) {
        Log.e("NATHAN1", "runTimeIndex -> " + index)

        if (index >= wk.exercises.size) {
            finish()
            return
        }
        Log.e("NATHAN1", "thing -> " + wk.exercises[index].name)
        object : CountDownTimer((wk.exercises[index].time /* * 60 */* 1000).toLong(), 1000) { // DEBUG / DEMO TODO
            override fun onTick(millisUntilFinished: Long) {
                var totsec = millisUntilFinished / 1000
//                var min = totsec / 60
                var min = totsec % 60
//                var sec = totsec % 60
                var sec = 0
                time.setText("$min:" + "%02d".format(sec))
                title.setText(wk.exercises[index].name)
            }
            override fun onFinish() {
                Log.e("NATHAN1", wk.exercises[index].name)
                // hanging up in here
                runCooldown(wk, wk.cooldown,index + 1, time, title)
            }
        }.start()
    }

    fun runCooldown(wk: Workout, cooldown: Int, index: Int, time: TextView, title: TextView) {

        if (index >= wk.exercises.size) {
            finish()
            return
        }
        Log.e("NATHAN1", "thing -> cooldown")
        object : CountDownTimer((cooldown * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var totsec = millisUntilFinished / 1000
                var min = totsec.div(60)
                var sec = totsec % 60

                time.setText("$min:" + "%02d".format(sec))
                title.setText("Cooldown")
            }
            override fun onFinish() {
                Log.e("NATHAN1", wk.exercises[index].name)
                // hanging up in here
                runExercise(wk, index, time, title)
            }
        }.start()
    }


}









