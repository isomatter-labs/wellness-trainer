package com.isomorphresearch.nathan.myapplication

import android.app.Application


class IsoApp() : Application() {
    companion object {
        var workouts: ArrayList<Workout> = arrayListOf()
    }
}