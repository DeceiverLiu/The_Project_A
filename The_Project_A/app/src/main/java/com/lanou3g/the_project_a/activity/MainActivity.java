package com.lanou3g.the_project_a.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.lanou3g.the_project_a.R;
import com.lanou3g.the_project_a.fragment.Goeat_Fragment;
import com.lanou3g.the_project_a.fragment.My_Fragment;
import com.lanou3g.the_project_a.fragment.WikipediaFragment;

//首页Activity
public class MainActivity extends AppCompatActivity implements OnClickListener{
    private RadioButton Food_wikipedia,Going_to_eat,My;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Food_wikipedia=(RadioButton)findViewById(R.id.Food_wikipedia);
        Going_to_eat = (RadioButton) findViewById (R.id.Going_to_eat);
        My = (RadioButton) findViewById (R.id.My);
        Food_wikipedia.setOnClickListener (this);
        Going_to_eat.setOnClickListener (this);
        My.setOnClickListener (this);
        merge (new WikipediaFragment ());
        Food_wikipedia.setChecked (true);


    }



    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.Food_wikipedia:
                merge (new WikipediaFragment ());
                break;
            case R.id.Going_to_eat:
                merge (new Goeat_Fragment ());
                break;
            case R.id.My:
                merge (new My_Fragment ());
                break;
        }
    }

    private void merge (Fragment fragment) {
        manager = getSupportFragmentManager ();
        transaction = manager.beginTransaction ();
        transaction.replace (R.id.Main_frameLayout,fragment);
        transaction.commit ();
    }
}
