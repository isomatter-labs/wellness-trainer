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


        thing(workout.exercises, 0, textView6)


        /*
            async is happening now
            tasks are being pushed to the background and running at the same time
            Trying to see if they can hang up until they get to onFinish
         */


//        for (exercise in workout.exercises) {
//            textView3.setText(exercise.name)
////            imageView2.setImageResource() // exercise image
//            Log.e("NATHAN1-1", exercise.name)
//            object : CountDownTimer((exercise.time * 60 * 1000).toLong(), 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    var totsec = millisUntilFinished / 1000
//                    var min = totsec.div(60)
//                    var sec = totsec % 60
//                    textView6.setText("$min:$sec")
//                }
//                override fun onFinish() {
//                    Log.e("NATHAN1-1", exercise.name)
//                    // hanging up in here
//                }
//            }.start()

//            imageView2.setImageResource() // cooldown image
//            object : CountDownTimer((workout.cooldown * 1000).toLong(), 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    var totsec = millisUntilFinished / 1000
//                    var min = totsec.div(60)
//                    var sec = totsec % 60
//                    textView6.setText("$min:$sec")
//                }
//                override fun onFinish() {
//                    Log.e("NATHAN1-1", "COOLDOWN")
//                }
//            }.start()

        } // last exercise has no cooldown after and makes alert message
//        textView3.setText(workout.exercises.last().name)
//            imageView2.setImageResource() // exercise image
//        object : CountDownTimer((workout.exercises.last().time * 60 * 1000).toLong(), 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                var totsec = millisUntilFinished / 1000
//                var min = totsec.div(60)
//                var sec = totsec % 60
//                textView6.setText("$min:$sec")
//            }
//            override fun onFinish() {
////                val mDialogView = LayoutInflater.from(super).inflate(com.isomorphresearch.nathan.myapplication.R.layout.dialog_workout_done, null)
//////                val mBuilder = Alertexercise.Dialog.Builder(this)
//////                    .setView(mDialogView)
//////                    .setTitle("Workout Finished!")
//////                val mAlertDialog = mBuilder.show()
////
////                mDialogView.dialogAddBtn.setOnClickListener {
////                    mAlertDialog.dismiss()
//
////                }
//                finish()
//            }
//        }.start()

    fun thing(lst: ArrayList<Exercise>, index: Int, context: TextView) {
        Log.e("NATHAN1", "thing -> " + lst[index].name)

        if (index >= lst.size) {
            return
        }
        object : CountDownTimer((lst[index].time * 60 * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var totsec = millisUntilFinished / 1000
                var min = totsec.div(60)
                var sec = totsec % 60

                context.setText("$min:$sec")
            }
            override fun onFinish() {
                Log.e("NATHAN1", lst[index].name)
                // hanging up in here
                thing(lst, index + 1, context)
            }
        }.start()


    }


}









