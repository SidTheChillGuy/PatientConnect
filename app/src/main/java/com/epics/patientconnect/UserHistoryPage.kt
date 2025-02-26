package com.epics.patientconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class UserHistoryPage : AppCompatActivity() {

    lateinit var expandableListView: ExpandableListView
    lateinit var adapter: CustomExpandableListAdapter
    lateinit var UserPageCaseIDtitleList: List<String>
    lateinit var UserPageCaseIDdataList: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_history_page)
      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.UserLandingPage)) { v, insets ->
          val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
          v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
          insets
      }

            expandableListView = findViewById(R.id.UserLandingCaseIdListView)

            setData()

            adapter = CustomExpandableListAdapter(this, UserPageCaseIDtitleList, UserPageCaseIDdataList)
            expandableListView.setAdapter(adapter)
    }

    private fun setData()
    {
        UserPageCaseIDtitleList = listOf("Case: 0001TEST", "Case: 0002VITB", "Case: 0003", "Case: 0004")

        UserPageCaseIDdataList = java.util.HashMap()

        // ayush saxena update this !!!
        UserPageCaseIDdataList[UserPageCaseIDtitleList[0]] = listOf("Detail 1: Bukhaar")
        UserPageCaseIDdataList[UserPageCaseIDtitleList[1]] = listOf("Detail 1: khansi","Detail 2: TB hai")
        UserPageCaseIDdataList[UserPageCaseIDtitleList[2]] = listOf("Detail 1: liver gayab","Detail 2: daaru peeta hai","Detail 3: admit krdo aa jayegi")
        UserPageCaseIDdataList[UserPageCaseIDtitleList[3]] = listOf("Detail 1: khoon kharab","Detail 2: nasha nhi krta","Detail 3: admit toh kia hai","Detail 4: cancer T~T")
    }



}