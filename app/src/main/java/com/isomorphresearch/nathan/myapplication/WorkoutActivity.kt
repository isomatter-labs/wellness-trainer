package com.isomorphresearch.nathan.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.app_bar_workout.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.dialog_add_exer.view.*

class WorkoutActivity : AppCompatActivity() {

    private var selectedWorkout: Workout? = null

    private lateinit var adapter: ExRecyclerAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        var workouts = IsoApp.workouts
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_workout)
        val position = intent.getIntExtra("WORKOUT", 0)
        selectedWorkout = workouts[position]

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = ExRecyclerAdapter(selectedWorkout!!.exercises, applicationContext)
        recyclerView.adapter = adapter

        fab1.setOnClickListener { view ->
            Snackbar.make(view, "Do it yourself!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        fab2.setOnClickListener { _ ->
            val workout = selectedWorkout // to allow changing exercises
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_exer, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("New Workout")
            val mAlertDialog = mBuilder.show()

            mDialogView.dialogAddBtn.setOnClickListener {
                mAlertDialog.dismiss()
                val newName = mDialogView.dialogExerNameEt.text.toString()
                val newDescription = mDialogView.dialogExerDescEt.text.toString()
                val newTimeStr = mDialogView.dialogExerTime.text.toString()
                var newTime = 0
                if (newTimeStr != "") {
                    newTime = newTimeStr.toInt()
                }
                workout?.exercises?.add(Exercise(name = newName, Desc = newDescription, time = newTime))
                adapter!!.notifyDataSetChanged()
            }

            mDialogView.dialogCancelBtn.setOnClickListener {
                mAlertDialog.dismiss()
            }

        }
    }



    companion object {
        //5`
        private val WORKOUT_KEY = "WORKOUT"
    }
}
