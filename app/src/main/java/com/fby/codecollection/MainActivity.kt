package com.fby.codecollection

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.fby.codecollection.util.getActivities
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var list: ArrayList<ActivityInfo>
    var listName = ArrayList<String>()
    var listPackageName = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        processData()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listName)
        sp.adapter = arrayAdapter
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (listName[p2] == "请选择") return
                val className = "${listName[p2]}"
                val activityClass = Class.forName(className)
                startActivity(Intent(this@MainActivity, activityClass))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun processData() {
        list = getActivities(this)
        listName.add("请选择")
        listPackageName.add("")
        for (info: ActivityInfo in list) {
            listName.add(info.name)
            listPackageName.add(info.packageName)
        }
    }
}