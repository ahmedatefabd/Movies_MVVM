package com.example.engahmedatef.movies_mvvm.callback;

import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.Movie;

import java.util.List;

public interface OnDataLisener {

    void onSucess(List<Movie> movieList);

    void onError(String errorMsg);
}
