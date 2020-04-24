package com.timsimonhughes.transitions.ui.containerTransform.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timsimonhughes.transitions.R
import com.timsimonhughes.transitions.model.Album
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_album.view.*

class ContainerTransformAdapter(private val onAlbumItemClick: OnAlbumItemClickListener?) :
    ListAdapter<Album, ContainerTransformAdapter.ContainerTransformViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContainerTransformViewHolder {
        return ContainerTransformViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_album,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContainerTransformViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ContainerTransformViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(album: Album) {
            itemView.apply {
                text_view_album_title.text = album.artistTitle
                text_view_album_description.text = album.albumTitle

                Glide.with(containerView.context)
                    .load(album.albumUrl)
                    .into(image_view_album)

                val transitionName = album.id.toString()
                ViewCompat.setTransitionName(containerView, transitionName)

                itemView.setOnClickListener {
                    onAlbumItemClick?.onAlbumItemClick(album, containerView, adapterPosition)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    interface OnAlbumItemClickListener {
        fun onAlbumItemClick(album: Album, view: View,  position: Int)
    }
}
