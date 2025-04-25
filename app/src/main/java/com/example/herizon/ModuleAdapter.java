package com.example.herizon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private List<Module> moduleList;

    public ModuleAdapter(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.moduleTitle);
            description = itemView.findViewById(R.id.moduleDesc);
        }
    }

    @Override
    public ModuleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_module, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModuleAdapter.ViewHolder holder, int position) {
        Module module = moduleList.get(position);
        holder.title.setText(module.getTitle());
        holder.description.setText(module.getDescription());
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }
}
