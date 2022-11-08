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

import java.util.LinkedList;
import java.util.List;

public class AttendListAdapter extends RecyclerView.Adapter<AttendListAdapter.AttendListViewHolder> {

    private List<AttendanceModel> data = new LinkedList<>();

    @NonNull
    @Override
    public AttendListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AttendListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_for_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AttendListViewHolder holder, int position) {
        AttendanceModel attendanceCurrent = data.get(position);

        if (attendanceCurrent == null) return;
        holder.tvStudentId.setText(attendanceCurrent.getStudent().toString());
        holder.absent.callOnClick();
        if (attendanceCurrent.isStatus()) {
            holder.absent.callOnClick();
            holder.present.callOnClick();
        }
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public void setData(List<AttendanceModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public class AttendListViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvStudentId;
        private final CheckBox present;
        private final CheckBox absent;

        public AttendListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentId = itemView.findViewById(R.id.id_student_name);
            present = itemView.findViewById(R.id.Present);
            absent = itemView.findViewById(R.id.Absent);
        }
    }
}
