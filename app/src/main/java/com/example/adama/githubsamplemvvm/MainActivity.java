package com.example.adama.githubsamplemvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adama.githubsamplemvvm.service.model.Project;
import com.example.adama.githubsamplemvvm.viewModel.ProjectListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProjectListViewModel viewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeProjectList(viewModel);
    }

    private void observeProjectList(ProjectListViewModel viewModel){
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if(projects != null)
                    Toast.makeText(MainActivity.this, projects.size()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
