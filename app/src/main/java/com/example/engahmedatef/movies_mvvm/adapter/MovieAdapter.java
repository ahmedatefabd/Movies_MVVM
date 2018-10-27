package com.example.engahmedatef.movies_mvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.engahmedatef.movies_mvvm.R;
import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.Movie;
import com.example.engahmedatef.movies_mvvm.ui.details_screen.DetailsActivity;
import com.example.engahmedatef.movies_mvvm.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieHolder> {

    private Context m_context;
    private List<Movie> movieList;

    public MovieAdapter(Context m_context, List<Movie> movieList) {
        this.m_context = m_context;
        this.movieList = movieList;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(m_context).inflate(R.layout.row, parent, false);
        MovieHolder holder = new MovieHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {

        final Movie movie = movieList.get(position);

        Picasso.get()
                .load(Constant.Api.BASE_IMAGE_URL + movie.getPosterPath())
                .into(holder.image_Item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(m_context , DetailsActivity.class);

                intent.putExtra(Constant.EXTRA.MOVIE , movie);

                m_context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_item_movie)
        ImageView image_Item;

        public MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
