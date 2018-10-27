package com.example.engahmedatef.movies_mvvm.ui.main_screen;

import com.example.engahmedatef.movies_mvvm.callback.OnDataLisener;
import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.Movie;
import com.example.engahmedatef.movies_mvvm.datamaodel.remote_data.ApiModel;
import com.example.engahmedatef.movies_mvvm.ui.base_screen.BaseViewModel;
import com.example.engahmedatef.movies_mvvm.util.Constant;

import java.util.List;

public class MainViewModel extends BaseViewModel {

    private ApiModel apiModel ;

    public MainViewModel() {
        apiModel = new ApiModel();
    }

    public void getDtatfromApiMpdel( String type ,final OnDataLisener listener){

        apiModel.getMovies(type , new OnDataLisener() {
            @Override
            public void onSucess(List<Movie> movieList) {
                 listener.onSucess(movieList);
            }

            @Override
            public void onError(String errorMsg) {

                listener.onError(errorMsg);
            }
        });
    }
}
