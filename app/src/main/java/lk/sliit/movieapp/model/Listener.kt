package lk.sliit.movieapp.model

interface Listener {
    fun onStarted()
    fun onSuccess()
    fun onFaliure(message: String)
}