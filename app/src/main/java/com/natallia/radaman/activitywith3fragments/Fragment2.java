package com.natallia.radaman.activitywith3fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * @author Natallia Radaman
 * @since 27-03-2018
 */

public class Fragment2 extends Fragment {
    private static final String BACKGROUND_COLOR = "color";

    private int color;
    private Button button1Fragment;
    private Button button3Fragment;

    public Fragment2() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(BACKGROUND_COLOR);
        } else {
            Random randomColorInt = new Random();
            color = Color.rgb(randomColorInt.nextInt(256), randomColorInt.nextInt(256),
                    randomColorInt.nextInt(256));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View frView = inflater.inflate(R.layout.fragment_fragment2, container, false);
        frView.findViewById(R.id.fragment2_layout).setBackgroundColor(color);
        button1Fragment = (Button) frView.findViewById(R.id.buttonToFirstFragment);
        button1Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).fragmentChoice(1);
            }
        });
        button3Fragment = (Button) frView.findViewById(R.id.buttonToThirdFragment);
        button3Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).fragmentChoice(3);
            }
        });
        return frView;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BACKGROUND_COLOR, color);
    }
}
