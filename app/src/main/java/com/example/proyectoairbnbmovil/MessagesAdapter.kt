package com.example.proyectoairbnbmovil

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAvatar: TextView = itemView.findViewById(R.id.tvAvatar)
        val tvMessageName: TextView = itemView.findViewById(R.id.tvMessageName)
        val tvLastMessage: TextView = itemView.findViewById(R.id.tvLastMessage)
        val tvMessageTime: TextView = itemView.findViewById(R.id.tvMessageTime)
        val tvUnread: TextView = itemView.findViewById(R.id.tvUnread)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.tvAvatar.text = message.initials
        holder.tvAvatar.backgroundTintList =
            android.content.res.ColorStateList.valueOf(Color.parseColor(message.avatarColor))
        holder.tvMessageName.text = message.name
        holder.tvLastMessage.text = message.lastMessage
        holder.tvMessageTime.text = message.time

        if (message.unread > 0) {
            holder.tvUnread.visibility = View.VISIBLE
            holder.tvUnread.text = message.unread.toString()
        } else {
            holder.tvUnread.visibility = View.GONE
        }
    }

    override fun getItemCount() = messages.size
}