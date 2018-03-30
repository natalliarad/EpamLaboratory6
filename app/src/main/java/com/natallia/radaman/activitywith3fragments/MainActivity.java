package com.natallia.radaman.activitywith3fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author Natallia Radaman
 * @since 27-03-2018
 */

public class MainActivity extends AppCompatActivity {
    private static final String NUMBER_FRAGMENT = "number_fragment";
    public static int numberOfFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            numberOfFragment = savedInstanceState.getInt(NUMBER_FRAGMENT);
        } else {
            numberOfFragment = 1;
            fragmentChoice(numberOfFragment);
        }
    }

    /**
     * Function to create fragment in MainActivity
     *
     * @param fragment
     */

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Switch fuction to set up and create needed fragment
     *
     * @param numberOfFragment
     */

    public void fragmentChoice(int numberOfFragment) {
        switch (numberOfFragment) {
            case 1:
                setFragment(new Fragment1());
                break;
            case 2:
                setFragment(new Fragment2());
                break;
            case 3:
                setFragment(new Fragment3());
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_FRAGMENT, numberOfFragment);
    }
}
