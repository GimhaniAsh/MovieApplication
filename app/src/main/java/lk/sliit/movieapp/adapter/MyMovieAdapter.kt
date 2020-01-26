package lk.sliit.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_movie_item.view.*
import lk.sliit.movieapp.R
import lk.sliit.movieapp.model.Movie
import java.security.AccessControlContext

class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //Picasso.get().load(movieList.[position].poster).into(holder.image_movie)
        holder.txttitle.text = movieList[position].name
        holder.txtwriter.text = movieList[position].createdby

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //var image : ImageView
        var txttitle : TextView
        var txtwriter : TextView

        init {


            txttitle = itemView.txttitle
            txtwriter = itemView.txtwriter
        }

    }
}