package ru.murtest.photogallery.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.murtest.photogallery.R
import ru.murtest.photogallery.databinding.ListItemGalleryBinding

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>
): RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(
        private val binding: ListItemGalleryBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryItem: GalleryItem) {
            binding.itemImageView.load(galleryItem.url) {
                placeholder(R.drawable.bill_up_close)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = galleryItems.size
}