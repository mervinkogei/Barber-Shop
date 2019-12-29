package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.barbershop.Common.Common;
import com.example.barbershop.Fragments.BookingFragment;
import com.example.barbershop.Fragments.HomeFragment;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    BottomSheetDialog bottomSheetDialog;

    CollectionReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(HomeActivity.this);

        //Initialization
        userRef = FirebaseFirestore.getInstance().collection("user");

        if (getIntent() !=null){
            boolean isLogin = getIntent().getBooleanExtra(Common.IS_LOGIN,false);
            if (isLogin){
                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    @Override
                    public void onSuccess(Account account) {
                        if (account != null){
                            DocumentReference currentUser = userRef.document(account.getPhoneNumber().toString());
                            currentUser.get()
                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                           if (task.isSuccessful()){
                                               DocumentSnapshot userSnapshot = task.getResult();
                                               if (!userSnapshot.exists())
                                                   showUpdateDialog(account.getPhoneNumber().toString());
                                           }
                                        }
                                    });
                        }
                        //view
                        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                            Fragment fragment = null;
                            @Override
                            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                                if (menuItem.getItemId()== R.id.action_home)
                                    fragment = new HomeFragment();
                                else if (menuItem.getItemId() == R.id.action_cart)
                                    fragment = new BookingFragment();

                                return loadFragment(fragment);
                            }
                        });

                    }

                    @Override
                    public void onError(AccountKitError accountKitError) {
                        Toast.makeText(HomeActivity.this, ""+accountKitError.getErrorType().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment)
            .commit();
            return true;
        }
        return  false;
    }

    private void showUpdateDialog(String phoneNumber) {
    }
}
