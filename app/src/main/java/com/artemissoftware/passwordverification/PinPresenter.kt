package com.artemissoftware.passwordverification

import com.artemissoftware.passwordverification.models.Pin

class PinPresenter(private val view: PinContract.View, private val pin: Pin = Pin()) : PinContract.Presenter{


    override fun loadNextScreen() {
        TODO("Not yet implemented")
    }

    override fun defaultSettings() {
        TODO("Not yet implemented")
    }

    override fun verifyEntries() {
        TODO("Not yet implemented")
    }

    override fun savePassword(password: String) {
        TODO("Not yet implemented")
    }

    override fun appendIndvidualPassword(
        first: String,
        second: String,
        third: String,
        fourth: String
    ): String {
        TODO("Not yet implemented")
    }
}