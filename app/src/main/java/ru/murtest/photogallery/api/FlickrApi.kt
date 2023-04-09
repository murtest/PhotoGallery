package ru.murtest.photogallery.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "959a80c7f3e35d9bfa7506abcf64c896"

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): FlickrResponse

    @GET("services/rest/?method=flickr.photos.search")
    suspend fun searchPhotos(@Query("text") query: String): FlickrResponse
}