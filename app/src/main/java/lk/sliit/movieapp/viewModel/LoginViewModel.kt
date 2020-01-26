package lk.sliit.movieapp.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import lk.sliit.movieapp.model.Listener

class LoginViewModel : ViewModel() {

    var username : String? = null
    var password : String? = null

    var listener: Listener? = null

    fun onLoginButtonClick(view: View){
        listener?.onStarted()

        if (username.isNullOrEmpty() || password.isNullOrEmpty()){

            listener?.onFaliure("Invalid username or password")
            return
        }

        else if (username.toString().equals("Movie") && password.toString().equals("1234")){
            listener?.onSuccess()
        }
        else
            listener?.onFaliure("Something went wrong!")

    }

}