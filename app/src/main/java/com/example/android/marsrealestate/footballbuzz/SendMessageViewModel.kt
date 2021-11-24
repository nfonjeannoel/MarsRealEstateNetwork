package com.example.android.marsrealestate.footballbuzz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SendMessageViewModel : ViewModel() {

    private val _messageSent = MutableLiveData<String?>()
    val messageSent : LiveData<String?>
        get() = _messageSent

    private val _messageNotSent = MutableLiveData<String?>()
    val messageNotSent : LiveData<String?>
        get() = _messageNotSent


    fun sendMessage(messageJson: HashMap<String, Any>, sessionToken: String) {
        viewModelScope.launch {
            try {
                val messageApiResponse = MessageApi.retrofitService.sendMessage(
                    sessionToken,
                    messageJson["UserIdSent"] as String,
                    messageJson)

                when(messageApiResponse.StatusCode){
                    200 -> _messageSent.value = messageApiResponse.Message
                    417 -> _messageNotSent.value = messageApiResponse.Message
                }
            } catch (e: Exception){
                _messageNotSent.value = e.message
            }
        }
    }

    fun messageSentComplete(){
        _messageSent.value = null
    }

    fun messageNotSentComplete(){
        _messageNotSent.value = null
    }


}