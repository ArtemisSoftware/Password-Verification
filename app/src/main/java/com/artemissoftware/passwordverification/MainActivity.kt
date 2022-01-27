package com.artemissoftware.passwordverification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.artemissoftware.passwordverification.databinding.ActivityMainBinding
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity(), PinContract.View {

    private lateinit var presenter: PinPresenter

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PinPresenter(view = this);
        presenter.defaultSettings()


        initClickListeners()
    }

    private fun initClickListeners(){

        binding.btnChoosePin.setOnClickListener {
            presenter.loadNextScreen()
        }


        binding.confirmpinOne.checkPinPassword()
        binding.confirmpinTwo.checkPinPassword()
        binding.confirmpinThree.checkPinPassword()
        binding.confirmpinFour.checkPinPassword()

        binding.newpinOne.checkPinPassword()
        binding.newpinTwo.checkPinPassword()
        binding.newpinThree.checkPinPassword()
        binding.newpinFour.checkPinPassword()
    }


    private fun EditText.checkPinPassword(){
        this.doOnTextChanged { text, start, before, count ->

            if (this != null && this.length() > 0) {
                this.focusSearch(View.FOCUS_RIGHT)?.requestFocus()
            }

            val password1 = presenter.appendIndvidualPassword(
                binding.newpinOne.text.toString(),
                binding.newpinTwo.text.toString(),
                binding.newpinThree.text.toString(),
                binding.newpinFour.text.toString()
            )
            val password2 = presenter.appendIndvidualPassword(
                binding.confirmpinOne.text.toString(),
                binding.confirmpinTwo.text.toString(),
                binding.confirmpinThree.text.toString(),
                binding.confirmpinFour.text.toString()
            )

            if (password1 == password2) {
                presenter.verifyEntries()
                presenter.savePassword(password1)
                return@doOnTextChanged
            }
            if (password1 != password2) {
                presenter.defaultSettings()
                return@doOnTextChanged
            }
        }
    }



    override fun showButtonClick(b: Boolean) {
        binding.btnChoosePin.isEnabled = b;
    }

    override fun setButtonColor(color: Int) {
        binding.btnChoosePin.background = resources.getDrawable(color);
    }

    override fun navigateNextScreen() {
        Toast.makeText(this, "Your intent goes here", Toast.LENGTH_SHORT).show();
    }

    override fun showError(error: String?) {
        TODO("Not yet implemented")
    }

    override fun showTickVisibility(value: Int) {
        binding.positivechecked1.visibility = value
        binding.positivechecked2.visibility = value
    }
}