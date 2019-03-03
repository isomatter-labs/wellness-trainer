package com.isomorphresearch.nathan.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.dialog_del_workout.view.*
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class ExRecyclerAdapter(private var exercises: ArrayList<Exercise>, var context: Context) : RecyclerView.Adapter<ExRecyclerAdapter.ExerciseHolder>() {

    override fun onBindViewHolder(holder: ExRecyclerAdapter.ExerciseHolder, position: Int) {
        val itemIndex = exercises[position]
        holder.bindWorkout(itemIndex)
    }

    override fun getItemCount() = exercises.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return ExerciseHolder(inflatedView)
    }


    //1
    inner class ExerciseHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var exercise: Exercise? = null

        //3
        init {
            v.setOnClickListener(this)
            v.findViewById<ImageView>(R.id.del_btn).setOnClickListener() {
                exercises.remove(exercise)
                notifyDataSetChanged()
            }
        }

        //4
        override fun onClick(v: View) {
//            Log.d("RecyclerView", "CLICK!")
//            val context = itemView.context
//            val showWorkoutIntent = Intent(context, WorkoutActivity::class.java)
//            showWorkoutIntent.putExtra("WORKOUT", workout)
//            context.startActivity(showWorkoutIntent)
        }

        fun bindWorkout(exercise: Exercise) {
            this.exercise = exercise
//            Picasso.with(view.context).load(workout.img).into(view.itemImage)
            view.itemDescription.text = exercise.name;
        }

//        companion object {
//            //5`
//            private val WORKOUT_KEY = "WORKOUT"
//        }
    }
}

