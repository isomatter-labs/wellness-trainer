package com.isomorphresearch.nathan.myapplication

import android.content.Intent
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private var workouts: ArrayList<Workout>) : RecyclerView.Adapter<RecyclerAdapter.WorkoutHolder>() {

    override fun onBindViewHolder(holder: RecyclerAdapter.WorkoutHolder, position: Int) {
        val itemIndex = workouts[position]
        holder.bindWorkout(itemIndex)
    }

    override fun getItemCount() = workouts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return WorkoutHolder(inflatedView)
    }


    //1
    class WorkoutHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var workout: Workout? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val context = itemView.context
            val showWorkoutIntent = Intent(context, WorkoutActivity::class.java)
            showWorkoutIntent.putExtra(WORKOUT_KEY, workout)
            context.startActivity(showWorkoutIntent)
        }

        fun bindWorkout(workout: Workout) {
            this.workout = workout
//            Picasso.with(view.context).load(workout.img).into(view.itemImage)
            view.itemDescription.text = workout.name;
        }

        companion object {
            //5`
            private val WORKOUT_KEY = "WORKOUT"
        }
    }
}

