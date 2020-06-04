package com.example.hackathonfinale;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.hackathonfinale.entities.Problem;
import com.example.hackathonfinale.entities.Question;
import com.example.hackathonfinale.network.DataRepository;

import java.util.ArrayList;

import timber.log.Timber;

public class RegistrationMain extends AppCompatActivity {
    RegistrationForEntityFragment registrationForEntityFragment;
    RegistrationForIndividualFragment registrationForIndividualFragment;
    FragmentTransaction fTrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationForEntityFragment = new RegistrationForEntityFragment();
        registrationForIndividualFragment = new RegistrationForIndividualFragment();
        RadioButton radioButtonEntity = findViewById(R.id.radioButtonEntity);
        radioButtonEntity.setOnClickListener(radioButtonClickListener);
        RadioButton radioButtonIndividual = findViewById(R.id.radioButtonIndividual);
        radioButtonIndividual.setOnClickListener(radioButtonClickListener);
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fTrans = getSupportFragmentManager().beginTransaction();
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radioButtonEntity:
                    fTrans.replace(R.id.frgmCont, registrationForEntityFragment);
                    break;
                case R.id.radioButtonIndividual:
                    fTrans.replace(R.id.frgmCont, registrationForIndividualFragment);
                    break;
                default:
                    break;
            }
            fTrans.commit();
        }
    };
}
