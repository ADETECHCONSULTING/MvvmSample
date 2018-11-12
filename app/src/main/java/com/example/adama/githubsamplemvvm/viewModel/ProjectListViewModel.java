package com.example.adama.githubsamplemvvm.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.adama.githubsamplemvvm.service.model.Project;
import com.example.adama.githubsamplemvvm.service.repo.ProjectRepository;

import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(@NonNull Application application) {
        super(application);


        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");
    }


    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
