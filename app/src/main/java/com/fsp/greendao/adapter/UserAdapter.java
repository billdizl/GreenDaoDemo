package com.fsp.greendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fsp.greendao.R;
import com.fsp.greendao.bean.UserInfo;

import java.util.List;

/**
 * Created by kaifa on 2017/6/28.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private Context mContext;
    private List<UserInfo> mList;
    public UserAdapter(Context context, List<UserInfo> list){
        this.mContext =context;
        this.mList =list;
    }
    public void setData(List<UserInfo> list){
        this.mList =list;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(mContext).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserInfo item =(UserInfo) mList.get(position);
            holder.tvName.setText(item.getName());
            holder.tvAge.setText(String.valueOf(item.getAge()));
           if(1==item.getSex()){
               holder.tvSex.setText("男");
           }else {
               holder.tvSex.setText("女");
           }
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvAge,tvSex;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
            tvSex = (TextView) itemView.findViewById(R.id.tv_sex);
        }
    }
}
