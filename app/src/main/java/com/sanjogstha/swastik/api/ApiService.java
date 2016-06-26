package com.sanjogstha.swastik.api;

import com.sanjogstha.swastik.model.Content;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 6/4/2016.
 */
public interface ApiService {
    /*
  Retrofit get annotation with our URL
  And our method that will return us the List of ContactList
  */
    @GET("e70ac777cb3c669732f5e05a5a965e22/raw/f2671c05f0ff867a9d912f233d8dd6f00ad41d52/swastik.json")
    Call<Content> getMyJSON();
}
