package com.example.engahmedatef.movies_mvvm.ui.details_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmedatef.movies_mvvm.R;
import com.example.engahmedatef.movies_mvvm.datamaodel.local_data.Movie;
import com.example.engahmedatef.movies_mvvm.ui.trailers_screen.TrailersActivity;
import com.example.engahmedatef.movies_mvvm.util.Constant;
import com.example.engahmedatef.movies_mvvm.util.FormatDate;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.cover_img)
    ImageView coverImg;
    @BindView(R.id.poster_img)
    ImageView posterImg;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_rating)
    TextView movieRating;
    @BindView(R.id.movie_release_date)
    TextView movieReleaseDate;
    @BindView(R.id.btn_Fav)
    FloatingActionButton btnFav;
    @BindView(R.id.movie_description)
    TextView movieDescription;
    @BindView(R.id.movie_trailers_btn)
    Button movieTrailersBtn;

    public Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        Bundle intent = getIntent().getExtras();

        final Movie movie = intent.getParcelable(Constant.EXTRA.MOVIE);
        mMovie = movie ;


        Picasso.get()
                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
                .into(posterImg);

        Picasso.get()
                .load(Constant.Api.BASE_IMAGE_URL + movie.getBackdropPath())
                .into(coverImg);

        movieTitle.setText("Title : " + movie.getTitle());
        movieRating.setText("Rating : " + movie.getVoteAverage());

        //formatDate()-->static method is used for change the date format ("yyyy-MM-dd") to ("dd-MM-yyyy")
        //formatDate()-->static method is inside Class-->(FormatDate) inside package-->(util)
        movieReleaseDate.setText("FormatDate : " + FormatDate.formatDate(movie.getReleaseDate()));
        movieDescription.setText("Description : " + movie.getOverview());
        movieTrailersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(DetailsActivity.this, TrailersActivity.class);

                intent1.putExtra(Constant.EXTRA.ID_MOVIE, movie.getId());

                startActivity(intent1);
            }
        });
    }
}
