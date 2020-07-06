package com.ardyyy.dev.androidmvvm.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.models.response.MovieItem
import com.ardyyy.dev.androidmvvm.utils.createCircularProgress
import kotlinx.android.synthetic.main.list_item_movie.view.*

class HomeAdapter(private val obj: List<MovieItem>, private var onClick: (MovieItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val TYPECONTENT = 1
    private val TYPELOADING = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return if (viewType == TYPELOADING) {
            val view = inflater.inflate(R.layout.skl_list_item_movieloading, parent, false)
            LoadingViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.list_item_movie, parent, false)
            ContentViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return obj.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (obj[position].isLoading)
            TYPELOADING
        else
            TYPECONTENT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) != TYPELOADING)
            (holder as ContentViewHolder).bind(obj[position], holder.itemView.context)
    }

    inner class ContentViewHolder(mView: View) :
        RecyclerView.ViewHolder(mView) {

        fun bind(
            item: MovieItem,
            mContext: Context
        ) {
            itemView.apply {
                iv_poster.load("https://image.tmdb.org/t/p/w500/${item.posterPath}") {
                    crossfade(true)
                    placeholder(createCircularProgress(mContext))
                }
                tv_title.text = item.title
                tv_releasedate.text = item.releaseDate
                tv_overview.text = if(item.overview.isNotBlank()) item.overview else "-"
                card_movieitem.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }

    inner class LoadingViewHolder(mView: View) : RecyclerView.ViewHolder(mView)

}