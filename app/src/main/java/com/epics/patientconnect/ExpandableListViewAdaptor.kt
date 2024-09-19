package com.epics.patientconnect

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.cardview.widget.CardView

class CustomExpandableListAdapter(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return dataList[titleList[listPosition]]!![expandedListPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return dataList[titleList[listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any {
        return titleList[listPosition]
    }

    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }

    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null)
        }

        val listTitle = view!!.findViewById<TextView>(android.R.id.text1)
        listTitle.setBackgroundResource(R.drawable.rounded_rectangle)
        listTitle.text = getGroup(listPosition) as String
        return view
    }

    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
//        val listTitle = view!!.findViewById<TextView>(android.R.id.text1)
//        listTitle.setBackgroundResource(R.drawable.rounded_rectangle)
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(android.R.layout.simple_list_item_1, null)
        }

        val expandedListText = view!!.findViewById<TextView>(android.R.id.text1)
        expandedListText.text = getChild(listPosition, expandedListPosition) as String
        val listTitle = view!!.findViewById<TextView>(android.R.id.text1)
        listTitle.setBackgroundResource(R.drawable.rounded_rectangle)
        return view
    }
}
