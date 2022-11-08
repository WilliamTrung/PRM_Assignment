package com.example.prm_assignment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm_assignment.R;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.models.AttendanceModel;
import com.example.prm_assignment.models.ClassModel;

import java.util.LinkedList;
import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassAdapterViewHolder> {

    private List<ClassModel> data = new LinkedList<>();

    @NonNull
    @Override
    public ClassAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClassAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapterViewHolder holder, int position) {
        ClassModel classModel = data.get(position);
        if(classModel == null) return;
        holder.tvMentor.setText(classModel.getMentor().name);
        holder.tvClass.setText(classModel.getRoom().id);
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public void setData(List<ClassModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class ClassAdapterViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvClass;
        private final TextView tvMentor;

        public ClassAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClass = itemView.findViewById(R.id.id_class_code);
            tvMentor = itemView.findViewById(R.id.id_mentor_name);
        }
    }
}
