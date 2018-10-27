package com.example.engahmedatef.movies_mvvm.datamaodel.remote_data;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.engahmedatef.movies_mvvm.callback.OnDataLisener;
import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.ResponseMovie;
import com.example.engahmedatef.movies_mvvm.util.Constant;

public class ApiModel {

    public void getMovies (String movieType ,final OnDataLisener listener){// referance mn no3 el interface el mogode fe package Callback ma3mol mn agl anadi 3la ay method da5l el interface mn 8eeer no used (ay methodes)

        AndroidNetworking.get(Constant.Api.BASE_URL + movieType ) // BASE_URL-->link-->class->constant->package->util
                .addQueryParameter(Constant.Api.TOKEN_NAME , Constant.Api.TOKEN_VALUE) // token_URL-->key & value-->class->constant->package->util
                .build()
                .getAsObject(ResponseMovie.class, new ParsedRequestListener<ResponseMovie>() { // return-->JsonObject--> convert to Object_java in class-->Response contain JsonArray convert to List<Movie> in class Movie

                    @Override
                    public void onResponse(ResponseMovie response) {
                        listener.onSucess(response.getMovies()); // hna ana bnady 3la el mathod fe interface mn 8eer maasta5demhaaaa no used method
                    }                                            // wkaman ba3tlaha Object mn el List<Movie> daaa kdaa hayro7 LL parameter el mawgod fe mthod el onSucess el fe class interface

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError.getErrorDetail());
                    }
                });
    }
}
