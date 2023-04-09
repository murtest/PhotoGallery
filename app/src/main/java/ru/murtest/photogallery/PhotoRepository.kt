package ru.murtest.photogallery

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.Query
import ru.murtest.photogallery.api.FlickrApi
import ru.murtest.photogallery.api.GalleryItem
import ru.murtest.photogallery.api.PhotoInterceptor

class PhotoRepository {
    private val flickrApi: FlickrApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        flickrApi = retrofit.create()
    }

    suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhoto(query: String): List<GalleryItem> = flickrApi.searchPhotos(query).photos.galleryItems
}