package com.isomorphresearch.nathan.myapplication

import java.io.Serializable

class Workout(var exercises: ArrayList<Exercise>, var cooldown: Int, var desc: String, var img: String, var name: String) : Serializable