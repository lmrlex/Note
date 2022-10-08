package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.R;

import java.util.List;

import pojo.MainContent;

public class MainRecyclerviewAdapter extends RecyclerView.Adapter<MainRecyclerviewAdapter.ViewHolder> {
    private List<MainContent> mmainContentList;
    View mainView;

    public MainRecyclerviewAdapter(List<MainContent> mainContentList) {
        mmainContentList = mainContentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "您点击了我", Toast.LENGTH_SHORT).show();

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainContent mainContent=mmainContentList.get(position);
        holder.textView.setText(mainContent.getMainContentTitle());
        holder.textView1.setText(mainContent.getMainDate());
    }

    @Override
    public int getItemCount() {
        return mmainContentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView=itemView;
            textView=itemView.findViewById(R.id.main_content_title);
            textView1=itemView.findViewById(R.id.main_time);
        }
    }
}
