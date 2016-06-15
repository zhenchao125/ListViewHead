package com.qianfeng.listviewhead;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14.
 */
public abstract class SimpleSectionAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener{
    private final SparseArray<SectionItem<T>> keyedSection;
    private int itemtResId;
    private int headerResId;
    private LayoutInflater inflater;
    private final List<SectionItem<T>> sectionItems;

    public SimpleSectionAdapter(ListView parent, int headerResId, int itemtResId){
        this.headerResId = headerResId;
        this.itemtResId = itemtResId;
        inflater = LayoutInflater.from(parent.getContext());
        sectionItems = new ArrayList<>();  //所有的SectionItem的集合
        keyedSection = new SparseArray<>();
        parent.setOnItemClickListener(this);
        
    }

    /**
     * AdapterView.OnItemClickListener 的方法
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
    }

    public void addSection(String title, T[] items){
        SectionItem<T> sectionItem = new SectionItem<>(title, items);
        //添加节，替换具有相同标题的现有节
        int currentIndex = sectionItems.indexOf(sectionItem);
        if(currentIndex >= 0){
            sectionItems.remove(sectionItem);
            sectionItems.add(currentIndex, sectionItem);
        }else {
            sectionItems.add(sectionItem);
        }

        notifyDataSetChanged();  //更新视图
    }

    @Override
    public boolean areAllItemsEnabled(){
        return true;
    }

    @Override
    public boolean isEnabled(int position){
        return super.isEnabled(position);
    }
}
