package com.bookclub.app.bookclub;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MatchListFragment.OnFragmentInteractionListener,
                                                               GeneralListFragment.OnFragmentInteractionListener,
                                                               SuggestionListFragment.OnFragmentInteractionListener {

    private final String MATCHLIST_ID = "matchlistfragment";
    private final String SUGGESTIONLIST_ID = "suggestionlistfragment";
    private final String GENERALLIST_ID = "generallistfragment";
    
    private Fragment generalListFragment;
    private Fragment matchListFragment;
    private Fragment suggestionListFragment;
    private FragmentManager fm = getSupportFragmentManager();
    Fragment active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        generalListFragment = new GeneralListFragment();
        active = generalListFragment;
        /*
        matchListFragment = new MatchListFragment();
        suggestionListFragment = new SuggestionListFragment();
         */
        // fm.beginTransaction().add(R.id.fragment_container, matchListFragment, MATCHLIST_ID).hide(matchListFragment).commit();
       // fm.beginTransaction().add(R.id.fragment_container, suggestionListFragment, SUGGESTIONLIST_ID).hide(suggestionListFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, generalListFragment, GENERALLIST_ID).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.generalList:
                    if (generalListFragment == null) generalListFragment = new GeneralListFragment();
                    fm.beginTransaction().hide(active).add(R.id.fragment_container, generalListFragment, GENERALLIST_ID).commit();
                    fm.beginTransaction().remove(active).commit();
                    active = null;
                    active = generalListFragment;
                    return true;
                case R.id.matchList:
                    if (matchListFragment == null) matchListFragment = new MatchListFragment();
                    fm.beginTransaction().hide(active).add(R.id.fragment_container, matchListFragment, MATCHLIST_ID).commit();
                    fm.beginTransaction().remove(active).commit();
                    active = null;
                    active = matchListFragment;
                    return true;
                case R.id.suggestionList:
                    System.out.println("Removed");
                    if (suggestionListFragment == null) suggestionListFragment = new SuggestionListFragment();
                    fm.beginTransaction().remove(active).add(R.id.fragment_container, suggestionListFragment, SUGGESTIONLIST_ID).commit();
                  //  fm.beginTransaction().remove(active).commit();
                    active = null;
                    active = suggestionListFragment;
                    return true;
            }
            return false;
        }
    };

}
