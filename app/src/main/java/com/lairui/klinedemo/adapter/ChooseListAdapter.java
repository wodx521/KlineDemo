package com.lairui.klinedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lairui.klinedemo.R;
import com.wanou.framelibrary.base.BaseRecycleViewAdapter;

import java.util.List;

/**
 * Author by wodx521
 * Date on 2018/12/13.
 */
public class ChooseListAdapter extends BaseRecycleViewAdapter {
    private List<String> mContentList;

    public ChooseListAdapter(Context context) {
        super(context);
    }

    public void setData(List<String> contentList) {
        mContentList = contentList;
        notifyDataSetChanged();
    }

    @Override
    protected int getItemRes() {
        return R.layout.item_content;
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ContentListViewHolder(view);
    }

    @Override
    protected void bindClickListener(RecyclerView.ViewHolder viewHolder, int position) {
        ContentListViewHolder contentListViewHolder = (ContentListViewHolder) viewHolder;
        contentListViewHolder.mTvContent.setText(mContentList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mContentList != null && mContentList.size() > 0) {
            return mContentList.size();
        }
        return 0;
    }


    static class ContentListViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContent;

        ContentListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
