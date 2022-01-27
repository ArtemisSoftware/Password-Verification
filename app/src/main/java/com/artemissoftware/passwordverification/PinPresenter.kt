package com.artemissoftware.passwordverification

import android.view.View
import com.artemissoftware.passwordverification.models.Pin
import java.lang.StringBuilder

class PinPresenter(
    private val view: PinContract.View,
    private val pin: Pin = Pin()
) : PinContract.Presenter{


    override fun loadNextScreen() {
        view.navigateNextScreen();
    }

    override fun defaultSettings() {
        view.setButtonColor(R.drawable.btn_ash);
        view.showButtonClick(false);
        view.showTickVisibility(View.INVISIBLE);
    }

    override fun verifyEntries() {
        view.setButtonColor(R.drawable.btn_red)
        view.showButtonClick(true)
        view.showTickVisibility(View.VISIBLE)
    }

    override fun savePassword(password: String) {
        pin.password = password
    }

    override fun appendIndvidualPassword(
        first: String,
        second: String,
        third: String,
        fourth: String
    ): String {

        return  StringBuilder().append(first).append(second).append(third).append(fourth).toString()
    }
}