package com.example.barbershop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @BindView(R.id.findStyle)
    Button mFindStyleButton;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;
    @BindView(R.id.bookBarber)
    Button mBookBarber;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer);
//        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
//        navigationView.setNavigationItemSelectedListener(this);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };



//        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");
//        mAppNameTextView.setTypeface(caviarFont);
        mFindStyleButton.setOnClickListener(this);
        mBookBarber.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v == mFindStyleButton) {
            Intent intent = new Intent(MainActivity.this, StylistActivity.class);
            startActivity(intent);
        }
        if (v == mBookBarber) {
            Intent intent = new Intent(MainActivity.this, BookingActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(mToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if (id == R.id.action_profile) {
            profile();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void profile() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item){
//        int id = item.getItemId();
//        switch (id){
//            case R.id.db:
//            Toast.makeText(getApplicationContext(),"Dashboard",Toast.LENGTH_SHORT).show();
//            break;
//
//            case R.id.prof:
//            Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();
//            break;
//
//            case  R.id.cal:
//            Toast.makeText(getApplicationContext(),"Calendar",Toast.LENGTH_SHORT).show();
//            break;
//
//            case R.id.book:
//            Toast.makeText(getApplicationContext(),"Bookings",Toast.LENGTH_SHORT).show();
//            break;
//
//            case R.id.pay:
//            Toast.makeText(getApplicationContext(),"Payment",Toast.LENGTH_SHORT).show();
//            break;
//
//            case R.id.set:
//            Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
//            break;
//
//            case  R.id.logout:
//            Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
//            break;
//        }
//        mDrawerLayout.closeDrawer(GravityCompat.START);
//        return  true;
//    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }

}