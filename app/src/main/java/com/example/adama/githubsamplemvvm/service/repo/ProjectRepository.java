package com.example.adama.githubsamplemvvm.service.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.adama.githubsamplemvvm.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {
    private IGitHubService gitHubService;
    private static ProjectRepository projectRepository;


    private ProjectRepository(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IGitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubService = retrofit.create(IGitHubService.class);

    }

    public static ProjectRepository getInstance(){
        if(projectRepository == null)
            projectRepository = new ProjectRepository();

        return projectRepository;
    }


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


    public LiveData<Project> getProjectDetail(String userId, String repoName){
        final MutableLiveData<Project> data = new MutableLiveData<>();

        gitHubService.getProjectDetails(userId, repoName).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                //later on
            }
        });

        return data;
    }
}
