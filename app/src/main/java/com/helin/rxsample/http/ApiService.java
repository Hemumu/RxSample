package com.helin.rxsample.http;


import com.helin.rxsample.enity.HttpResult;
import com.helin.rxsample.enity.UserEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by helin on 2016/10/9 17:09.
 */

public interface ApiService {
    @GET("/student/mobileRegister")
    Observable<HttpResult<UserEntity>> login(@Query("phone") String phone, @Query("password") String psw);

    @GET("top250")
    Call<HttpResult> getTopMovie(@Query("start") int start, @Query("count") int count);

}
