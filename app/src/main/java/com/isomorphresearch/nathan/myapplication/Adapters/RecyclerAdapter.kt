package com.isomorphresearch.nathan.myapplication.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.isomorphresearch.nathan.myapplication.Classes.Workout
import com.isomorphresearch.nathan.myapplication.IsoApp
import com.isomorphresearch.nathan.myapplication.R
import com.isomorphresearch.nathan.myapplication.Activities.WorkoutActivity
import com.isomorphresearch.nathan.myapplication.inflate
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.WorkoutHolder>() {

    var wPosition: Int? = null
    override fun onBindViewHolder(holder: WorkoutHolder, position: Int) {
        val itemIndex = IsoApp.workouts[position]
        wPosition = position
        holder.bindWorkout(itemIndex)
    }

    override fun getItemCount() = IsoApp.workouts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return WorkoutHolder(inflatedView)
    }


    //1
    inner class WorkoutHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var workout: Workout? = null

        //3
        init {
            v.setOnClickListener(this)
            v.findViewById<ImageView>(R.id.del_btn).setOnClickListener() {
//                val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_del_workout, null)
//                val mBuilder = AlertDialog.Builder(context)
//                    .setView(mDialogView)
//                    .setTitle("Delete Workout?")
//                val mAlertDialog = mBuilder.show()
//
//                mDialogView.dialogDelBtn.setOnClickListener {
//                    mAlertDialog.dismiss()
//                    workouts.remove(workout)
//                    notifyDataSetChanged()
//                }
//
//                mDialogView.dialogCancelBtn.setOnClickListener {
//                    mAlertDialog.dismiss()
//                }
                IsoApp.workouts.remove(workout)
                notifyDataSetChanged()
            }
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val context = itemView.context
            val intent = Intent(context, WorkoutActivity::class.java)
            intent.putExtra("WORKOUT", wPosition)
            (context as Activity).startActivityForResult(intent, 1)
        }

        fun bindWorkout(workout: Workout) {
            this.workout = workout
//            Picasso.with(view.context).load(workout.img).into(view.itemImage)         
            view.itemName.text = workout.name;
            view.itemDesc.text = workout.desc;
            view.imageView4.setImageResource(R.drawable.ic_logo)
            var totalSecs = 0
            if (workout.exercises.size > 0) {
                totalSecs += workout.cooldown * (workout.exercises.size - 1)
            }
            for (exercise in workout.exercises) {
                totalSecs += exercise.time * 60 // in seconds
            }
            var minutes = totalSecs / 60
            var seconds = totalSecs % 60

                view.time.text = ("$minutes:" + "%02d".format(seconds))
//            view.time.text = ("$totalSecs")

        }
    }
}


