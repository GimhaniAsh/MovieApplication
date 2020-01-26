package lk.sliit.movieapp.view

import android.app.AlertDialog
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout

import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_movie.*
import lk.sliit.movieapp.R
import lk.sliit.movieapp.adapter.MyMovieAdapter
import lk.sliit.movieapp.common.Common
import lk.sliit.movieapp.model.Movie
import lk.sliit.movieapp.ui.RetrofitService
import retrofit2.Call
import retrofit2.Response


class MovieActivity : AppCompatActivity() {

    lateinit var  mService: RetrofitService
    lateinit var  layoutManager:LinearLayoutManager
    lateinit var  adapter:MyMovieAdapter
    lateinit var  dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        mService = Common.retrofitService

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()


    }

    private fun getAllMovieList() {
        dialog.show()

        mService.run {
            getMovieList().enqueue(object : retrofit2.Callback<MutableList<Movie>> {
                override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                    adapter = MyMovieAdapter(baseContext,response.body() as MutableList<Movie>)
                    adapter.notifyDataSetChanged()
                    recyclerMovieList.adapter = adapter

                    dialog.dismiss()
                }

            })
        }
    }
}
