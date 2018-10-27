package com.example.engahmedatef.movies_mvvm.ui.main_screen;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.engahmedatef.movies_mvvm.R;
import com.example.engahmedatef.movies_mvvm.adapter.MovieAdapter;
import com.example.engahmedatef.movies_mvvm.callback.OnDataLisener;
import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.Movie;
import com.example.engahmedatef.movies_mvvm.ui.base_screen.BaseActivity;
import com.example.engahmedatef.movies_mvvm.util.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private MovieAdapter adapter ;
    private MainViewModel viewModel ;

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = new MainViewModel();

        getDatafromMainViewModel(Constant.Api.POPULAR_MOVIES_KEY);

    }

    private void getDatafromMainViewModel(String type) {

        viewModel.getDtatfromApiMpdel(type , new OnDataLisener() {
            @Override
            public void onSucess(List<Movie> movieList) {

                recyclerview(movieList);
            }

            @Override
            public void onError(String errorMsg) {

                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void recyclerview(List<Movie> movieList) {

        adapter = new MovieAdapter(MainActivity.this, movieList);
        recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.popular:
                getDatafromMainViewModel(Constant.Api.POPULAR_MOVIES_KEY); // Method download Movies by Library-->Fastnetwark
//                return true;
                break;

            case R.id.top_rated:

                getDatafromMainViewModel(Constant.Api.TOP_RATED_MOVIES_KEY);// Method download Movies by Library-->Fastnetwark

                break;


        }
        return super.onOptionsItemSelected(item);

    }
}
