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

class RecyclerAdapter(private var workouts: ArrayList<Workout>, var context: Context) : RecyclerView.Adapter<RecyclerAdapter.WorkoutHolder>() {

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
                workouts.remove(workout)
                notifyDataSetChanged()
            }
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val context = itemView.context
            val showWorkoutIntent = Intent(context, WorkoutActivity::class.java)
            showWorkoutIntent.putExtra("WORKOUT", workout)
            context.startActivity(showWorkoutIntent)
        }

        fun bindWorkout(workout: Workout) {
            this.workout = workout
//            Picasso.with(view.context).load(workout.img).into(view.itemImage)
            view.itemDescription.text = workout.name;
        }

//        companion object {
//            //5`
//            private val WORKOUT_KEY = "WORKOUT"
//        }
    }
}

