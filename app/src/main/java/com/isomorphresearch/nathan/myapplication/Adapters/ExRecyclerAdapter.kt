package com.isomorphresearch.nathan.myapplication.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.isomorphresearch.nathan.myapplication.Classes.Exercise
import com.isomorphresearch.nathan.myapplication.R
import com.isomorphresearch.nathan.myapplication.inflate
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class ExRecyclerAdapter(private var exercises: ArrayList<Exercise>, var context: Context) : RecyclerView.Adapter<ExRecyclerAdapter.ExerciseHolder>() {

    override fun onBindViewHolder(holder: ExerciseHolder, position: Int) {
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
            view.itemName.text = exercise.name;
            view.itemDesc.text = exercise.Desc;
            view.imageView4.setImageResource(R.drawable.ic_logo)
            view.time.text = exercise.time.toString()
        }

//        companion object {
//            //5`
//            private val WORKOUT_KEY = "WORKOUT"
//        }
    }
}

