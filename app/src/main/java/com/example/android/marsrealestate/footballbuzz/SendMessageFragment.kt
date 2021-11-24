package com.example.android.marsrealestate.footballbuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class OverviewFragment : Fragment() {
    private val viewModel: SendMessageViewModel by lazy {
        ViewModelProvider(this).get(SendMessageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.messageSent.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()){
                //message content has changed, so message sent successfully
                //here, show indications that message send successfully

                viewModel.messageSentComplete()
            }
        })

        viewModel.messageNotSent.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()){
                //message has not been sent
                //notify user that message not sent


                //reset the variable for message not sent in viewModel
                viewModel.messageNotSentComplete()
            }
        })

    }


    //called when send message button is clicked
    //TODO("Handle case where message has media")
    fun sendMessage() {
        val sessionToken = getSessionToken()
        val userIdSent: String = getUserIdSent()
        val userIdReceived: String = getUserIdReceived()
        val messageContent: String = getMessageContent()
        val messageMedia: String = getMessageMedia()
        val timeStamp: String = formatTimeStamp(System.currentTimeMillis())

        val messageJson = hashMapOf<String, Any>(
            "UserIdSent" to userIdSent,
            "UserIdReceived" to userIdReceived,
            "ConversationKey" to "",
            "MessageContent" to messageContent,
            "MessageMedia" to messageMedia,
            "TimeStamp" to timeStamp,
            "Seen" to false,
            "SendByThisUser" to "YES"
        )
        viewModel.sendMessage(messageJson, sessionToken)

    }

    private fun getSessionToken(): String {
        TODO("Not yet implemented")
    }

    fun formatTimeStamp(currentTimeMillis: Long): String {
        TODO("Not yet implemented")
    }

    fun getMessageMedia(): String {
        TODO("Not yet implemented")
    }

    fun getMessageContent(): String {
        TODO("Not yet implemented")
    }

    fun getUserIdReceived(): String {
        TODO("Not yet implemented")
    }

    fun getUserIdSent(): String {
        TODO("Not yet implemented")
    }
}


