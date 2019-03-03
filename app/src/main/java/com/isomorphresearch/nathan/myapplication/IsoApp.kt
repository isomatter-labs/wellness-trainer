package com.isomorphresearch.nathan.myapplication

import android.app.Application
import com.isomorphresearch.nathan.myapplication.Classes.Exercise
import com.isomorphresearch.nathan.myapplication.Classes.Workout


class IsoApp() : Application() {
    companion object {
        var workouts: ArrayList<Workout> = arrayListOf(
            Workout(arrayListOf(Exercise("JumpingJacks", "Jump up and down and wave your arms from above your head to your sides.", 15),
                                Exercise("Run", "Run around campus.", 25),
                                Exercise("Pushups", "Do as many pushups as you can!", 15),
                                Exercise("Sit-Ups", "Do a situp about every 2 seconds.", 5)), 10, "Workout for after breakfast", "", "Morning Workout"),

            Workout(arrayListOf(Exercise("Toe Touch", "Sit and try to touch your toes without bending your legs.", 15),
                                Exercise("Bicycle kicks", "Lie on your back and kick your legs.", 25),
                                Exercise("Happy Baby", "Lie on your back and grab your feet.", 5)), 10, "Yoga after lunch for digestion", "", "Afternoon Yoga"),

            Workout(arrayListOf(Exercise("JumpingJacks", "Jump up and down and wave your arms from above your head to your sides.", 5),
                                Exercise("Run", "Run in place", 3),
                                Exercise("Pushups", "Do as many pushups as you can!", 2),
                                Exercise("Sit-Ups", "Do a situp about every 2 seconds.", 2)), 10, "Wear yourself out so you sleep", "", "Bedtime"))
    }
}