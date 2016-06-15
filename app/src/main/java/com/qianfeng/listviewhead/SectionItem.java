package com.qianfeng.listviewhead;

/**
 * Created by Administrator on 2016/6/14.
 */
public class SectionItem<T>{
    private String titile;
    private T[] items;

    public SectionItem(String titile, T[] items){

        this.titile = titile == null ? "" : titile;;
        this.items = items;
    }

    public String getTitile(){
        return titile;
    }

    public void setTitile(String titile){
        this.titile = titile;
    }

    public T[] getItems(){
        return items;
    }

    public void setItems(T[] items){
        this.items = items;
    }

    /**
     * 每节包含的项的数量
     * @return
     */
    public int getCount(){
        //每节包含的项的数量
        return items == null ? 1 : 1 + items.length;
    }
}
