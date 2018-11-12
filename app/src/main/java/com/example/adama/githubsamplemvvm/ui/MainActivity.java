package com.example.adama.githubsamplemvvm.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adama.githubsamplemvvm.R;
import com.example.adama.githubsamplemvvm.service.model.Project;
import com.example.adama.githubsamplemvvm.ui.fragment.ProjectListFragment;
import com.example.adama.githubsamplemvvm.viewModel.ProjectListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeFragment(new ProjectListFragment());
    }


    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //Some anim
        fragmentTransaction.replace(R.id.ctnFragment, fragment);
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() == 0){
            super.onBackPressed();
        }else{
            fragmentManager.popBackStack();
        }
    }
}
