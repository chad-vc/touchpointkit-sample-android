package com.visioncritical.touchpointapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyListAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val description: Array<String>
)
    : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var rowView: View? = view

        var mViewHolder: ViewHolder? = null

        if (rowView == null) {
            mViewHolder = ViewHolder()
            val vi: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowView = vi.inflate(R.layout.custom_list, parent, false)

            mViewHolder.titleText = rowView.findViewById(R.id.title) as TextView
            mViewHolder.imageView = rowView.findViewById(R.id.icon) as ImageView
            mViewHolder.subtitleText = rowView.findViewById(R.id.description) as TextView

            rowView.tag = mViewHolder
        } else {
            mViewHolder = rowView.tag as ViewHolder
        }

        mViewHolder.titleText?.text = title[position]
        mViewHolder.imageView?.setImageResource(R.drawable.profile)
        mViewHolder.subtitleText?.text = description[position]

//        if (position == 0) {
//            mViewHolder.imageView?.visibility =  View.GONE
//            rowView?.setBackgroundColor(Color.YELLOW)
//        } else {
//            mViewHolder.imageView?.visibility =  View.VISIBLE
//            rowView?.setBackgroundColor(Color.WHITE)
//        }

        return rowView!!
    }

    internal class ViewHolder {
         var titleText: TextView? = null
         var imageView: ImageView? = null
         var subtitleText: TextView? = null
    }
}