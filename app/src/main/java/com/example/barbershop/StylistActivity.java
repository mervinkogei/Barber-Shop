package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.barbershop.Adapter.MyBarberStylistAdapter;
import com.example.barbershop.Interface.BarberApi;
import com.example.barbershop.Models.BarberClient;
import com.example.barbershop.Models.BarberStylistResponse;
import com.example.barbershop.Models.Hit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StylistActivity extends AppCompatActivity {

    private static final String TAG = StylistActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private MyBarberStylistAdapter mAdapter;

    public List<Hit> hits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylist_activity);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        BarberApi client = BarberClient.getClient();

        Call<BarberStylistResponse> call = client.getBarberStylist();

        call.enqueue(new Callback<BarberStylistResponse>() {
            @Override
            public void onResponse(Call<BarberStylistResponse> call, Response<BarberStylistResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    hits = response.body().getHits();
                    mAdapter = new MyBarberStylistAdapter(StylistActivity.this, hits);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(StylistActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showRestaurants();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<BarberStylistResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }


    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }



    }
