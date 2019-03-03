package com.isomorphresearch.nathan.myapplication

import android.app.Application
import com.isomorphresearch.nathan.myapplication.Classes.Workout


class IsoApp() : Application() {
    companion object {
        var workouts: ArrayList<Workout> = arrayListOf()
    }
}