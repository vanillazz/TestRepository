package com.ardyyy.dev.androidmvvm.presentation.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ardyyy.dev.androidmvvm.R
import com.ardyyy.dev.androidmvvm.data.local.entity.FavoriteMovie
import com.ardyyy.dev.androidmvvm.utils.createCircularProgress
import kotlinx.android.synthetic.main.list_item_movie.view.*

class FavoriteAdapter(val obj: List<FavoriteMovie>, private var onClick: (FavoriteMovie) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item_movie, parent, false)
        return ContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return obj.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContentViewHolder).bind(obj.get(position), holder.itemView.context)
    }

    inner class ContentViewHolder(mView: View) :
        RecyclerView.ViewHolder(mView) {

        fun bind(
            item: FavoriteMovie,
            mContext: Context
        ) {
            itemView.apply {
                iv_poster.load("https://image.tmdb.org/t/p/w500/${item.posterPath}") {
                    crossfade(true)
                    placeholder(createCircularProgress(mContext))
                }
                tv_title.text = item.title
                tv_releasedate.text = item.releaseDate
                tv_overview.text = item.overview
                card_movieitem.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }
}