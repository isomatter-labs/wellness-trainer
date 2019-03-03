package com.isomorphresearch.nathan.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.dialog_add_name.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var adapter: RecyclerAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    private val lastVisibleItemPosition: Int
        get() = linearLayoutManager.findLastVisibleItemPosition()

    override fun onCreate(savedInstanceState: Bundle?) {
        var workoutList = IsoApp.workouts
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(applicationContext)
        recyclerView.adapter = adapter

        fab.setOnClickListener { view ->
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_name, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("New Workout")
            val mAlertDialog = mBuilder.show()

            mDialogView.dialogAddBtn.setOnClickListener {
                mAlertDialog.dismiss()
                val newName = mDialogView.dialogNameEt.text.toString()
                val newDescription = mDialogView.dialogDescEt.text.toString()
                var newCooldown = 0
                val newCooldownStr = mDialogView.dialogTimeEt.text.toString()
                if (newCooldownStr != "") {
                    newCooldown = newCooldownStr.toInt()
                }
                workoutList.add(Workout(name=newName, cooldown = newCooldown, desc = newDescription, img="", exercises = arrayListOf()))
                adapter!!.notifyDataSetChanged()
            }

            mDialogView.dialogCancelBtn.setOnClickListener {
                mAlertDialog.dismiss()
            }

            Snackbar.make(view, "Workthing Added", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }





    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


//    override fun onStart() {
//        super.onStart()
//        if (photosList.size == 0) {
//            requestPhoto()
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
