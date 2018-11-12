package com.example.adama.githubsamplemvvm.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adama.githubsamplemvvm.R;
import com.example.adama.githubsamplemvvm.service.model.Project;
import com.example.adama.githubsamplemvvm.ui.MainActivity;
import com.example.adama.githubsamplemvvm.ui.adapter.ProjectListAdapter;
import com.example.adama.githubsamplemvvm.viewModel.ProjectListViewModel;

import java.util.List;

public class ProjectListFragment extends Fragment {
    RecyclerView rcvProjectList;
    ProjectListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.project_list_fragment, container, false);
        rcvProjectList = view.findViewById(R.id.rcvProjectList);
        rcvProjectList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ProjectListAdapter();
        rcvProjectList.setAdapter(adapter);

        final ProjectListViewModel viewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeProjectList(viewModel);
    }

    private void observeProjectList(ProjectListViewModel viewModel){
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if(projects != null)
                    adapter.setProjects(projects);
            }
        });
    }
}
