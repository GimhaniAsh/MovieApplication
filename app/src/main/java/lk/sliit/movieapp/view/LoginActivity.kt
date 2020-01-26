package lk.sliit.movieapp.view

import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*
import lk.sliit.movieapp.model.Listener
import lk.sliit.movieapp.R
import lk.sliit.movieapp.util.toast
import lk.sliit.movieapp.viewModel.LoginViewModel
import lk.sliit.movieapp.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity(), Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.listener = this

    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess() {
        toast("Login Success")
        val intent = Intent(this,MovieActivity::class.java)
        startActivity(intent)

    }

    override fun onFaliure(message: String) {
        toast(message)
    }


}
