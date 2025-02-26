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
        UserPageCaseIDtitleList = listOf("Case: 0001", "Case: 0002")

        UserPageCaseIDdataList = java.util.HashMap()

        UserPageCaseIDdataList[UserPageCaseIDtitleList[0]] = listOf("\tDate:15 February 2025\nReport:\nLeg Fracture:\n\t- Requested Xray")
        UserPageCaseIDdataList[UserPageCaseIDtitleList[1]] = listOf("\tDate:16 February 2025\nReport:\nCrack at Foot base\nRecommended rest for 40days")
    }



}