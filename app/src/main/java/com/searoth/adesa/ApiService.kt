package com.searoth.adesa

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET fun getThing(@Query("sources") sources: String) : Observable<String>
}