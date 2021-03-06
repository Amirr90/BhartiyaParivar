package com.e.bhartiyaparivar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.bhartiyaparivar.databinding.DashboardSideMenuViewBinding;
import com.e.bhartiyaparivar.interfaces.NavigationInterface;
import com.e.bhartiyaparivar.model.NavModel;

import java.util.List;

public class NavAdapter extends RecyclerView.Adapter<NavAdapter.NavVH> {
    List<NavModel> navModelList;
    NavigationInterface adapterInterface;


    public NavAdapter(List<NavModel> navModelList, NavigationInterface adapterInterface) {
        this.navModelList = navModelList;
        this.adapterInterface = adapterInterface;
    }


    @NonNull
    @Override
    public NavVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DashboardSideMenuViewBinding navViewRecItemBinding = DashboardSideMenuViewBinding.inflate(inflater, parent, false);
        return new NavVH(navViewRecItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NavVH holder, final int position) {

        NavModel navModel = navModelList.get(position);
        holder.navViewRecItemBinding.setNavModel(navModel);

        holder.navViewRecItemBinding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterInterface.onNavigationItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return navModelList.size();
    }

    public class NavVH extends RecyclerView.ViewHolder {
        DashboardSideMenuViewBinding navViewRecItemBinding;

        public NavVH(DashboardSideMenuViewBinding navViewRecItemBinding) {
            super(navViewRecItemBinding.getRoot());
            this.navViewRecItemBinding = navViewRecItemBinding;
        }
    }
}
