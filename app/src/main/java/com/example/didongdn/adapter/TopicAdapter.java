package com.example.didongdn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didongdn.R;
import com.example.didongdn.model.Topic;

import java.util.List;

public class TopicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Topic> topicList;

    public TopicAdapter(Context context, int layout, List<Topic> topicList) {
        this.context = context;
        this.layout = layout;
        this.topicList = topicList;
    }

    public int getCount() {
        return topicList.size();
    }
    private class ViewHolder{
        TextView txtChuDe,txtStart,txtType;
        ImageView imgAnh;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null)
        {
          holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtChuDe = view.findViewById(R.id.txtChuDe);
            holder.txtStart = view.findViewById(R.id.txtStart);
            holder.txtType = view.findViewById(R.id.txtType);
            holder.imgAnh = view.findViewById(R.id.imgAnh);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Topic topic = topicList.get(i);
        holder.txtChuDe.setText(topic.getTitle());
        holder.txtStart.setText("Started by " + topic.getCreator().getUsername() + "," + topic.getCreatedAt());
        holder.txtType.setText(topic.getTopicType());


        return view;
    }
}
