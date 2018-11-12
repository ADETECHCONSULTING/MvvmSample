package com.example.adama.githubsamplemvvm.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adama.githubsamplemvvm.R;
import com.example.adama.githubsamplemvvm.service.model.Project;

import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListHolder> {
    private List<Project> projects;

    public void setProjects(List<Project> projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProjectListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_list_item, viewGroup, false);
        ProjectListHolder holder = new ProjectListHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListHolder projectListHolder, int i) {
        projectListHolder.txvProject.setText(projects.get(i).name);
    }

    @Override
    public int getItemCount() {
        return projects != null ? projects.size() : 0;
    }

    public class ProjectListHolder extends RecyclerView.ViewHolder{
        TextView txvProject;

        public ProjectListHolder(@NonNull View itemView) {
            super(itemView);

            txvProject = itemView.findViewById(R.id.txvProject);
        }
    }
}
