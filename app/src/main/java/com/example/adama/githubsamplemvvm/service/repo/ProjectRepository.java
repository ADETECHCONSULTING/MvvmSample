package com.example.adama.githubsamplemvvm.service.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.adama.githubsamplemvvm.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectRepository {
    private IGitHubService gitHubService;

    public LiveData<List<Project>> getProjectList(String userId){
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                //later on
            }
        });

        return data;
    }
}
