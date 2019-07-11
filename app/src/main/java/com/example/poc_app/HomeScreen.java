package com.example.poc_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private GoogleSignInClient mGoogleSignInClient;
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private String UserName;
    private TextView textViewUserName;

    List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //pass gso object through shared preference
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        findViewById(R.id.btn_Logout).setOnClickListener(this);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        textViewUserName = (TextView) findViewById(R.id.textViewUserName);
        UserName=getIntent().getExtras().getString("UserName");
        textViewUserName.setText("Hare Krishna "+UserName);

        eventList =new ArrayList<>();

        recyclerView =(RecyclerView) findViewById(R.id.homescreenRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventList.add(new Event( 1,"Balarama Jayanti","17th July,2019"));
        eventList.add(new Event( 1,"Krishna Janmastami","17th August,2019"));
        eventList.add(new Event( 1,"Radhastami Celebrations","17th September,2019"));

        adapter=new EventAdapter(this,eventList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Logout:
                logOut();
                break;
            // ...
        }
    }

    private void logOut() {

        mGoogleSignInClient.signOut();
        FirebaseAuth.getInstance().signOut();
        Log.w("Info", "Signed Out");
        startActivity(new Intent(HomeScreen.this,LoginScreen.class));
    }
}
