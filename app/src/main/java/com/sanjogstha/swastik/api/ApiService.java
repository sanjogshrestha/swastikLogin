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
    @GET("/json_data.json")
    Call<Content> getMyJSON();
}
