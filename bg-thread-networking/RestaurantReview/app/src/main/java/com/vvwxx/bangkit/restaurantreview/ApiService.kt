package com.vvwxx.bangkit.restaurantreview

import retrofit2.Call
import retrofit2.http.*

// merupakan interface yang berisi kumpulan endpoint yang digunakan pada sebuah aplikasi
interface ApiService {
    @GET("detail/{id}")
    fun getRestaurant(
        @Path("id") id: String
    ): Call<RestaurantResponse>

    @FormUrlEncoded
    @Headers("Authorization: token 12345")
    @POST("review")
    fun postReview(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("review") review: String,
    ): Call<PostReviewResponse>
}