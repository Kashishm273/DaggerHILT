package com.example.daggerhilt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R
import com.example.daggerhilt.data.Log
import com.example.daggerhilt.util.DateFormatter
import kotlinx.android.synthetic.main.layout_item_log.view.*

class LogsAdapter(
    private val logs: List<Log>,
    private val dateFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        return LogsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_log,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logs[position]
        holder.bind("${log.message}\n\t${dateFormatter.formatDate(log.timeStamp)}")
    }

    override fun getItemCount(): Int {
        return logs.size
    }
}


class LogsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(date: String) {
        itemView.text.text = date
    }

}
