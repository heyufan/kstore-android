package com.qianmi.kstore.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianmi.kstore.R;

/**
 * Created by 20150622 on 2015/8/2.
 * 商品列表页面的头部排序控件
 */
public class GoodsListTitleFragment extends Fragment {
    //按综合排序控件
    private TextView goodsListSortCommonTxt = null;
    //按销量排序控件
    private TextView goodsListSortSaleTxt = null;
    //按价格排序控件
    private TextView goodsListSortPriceTxt = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_list_title, container, false);
        initView(view);
        bindOnclickListener();
        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        goodsListSortCommonTxt = (TextView) view.findViewById(R.id.goods_list_sort_common);
        goodsListSortPriceTxt = (TextView) view.findViewById(R.id.goods_list_sort_price);
        goodsListSortSaleTxt = (TextView) view.findViewById(R.id.goods_list_sort_sale);
    }

    /**
     * 绑定监听
     * 当点击任一排序控件后，改变当前控件样式。还原其他控件样式
     */
    private void bindOnclickListener() {
        goodsListSortCommonTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsListSortCommonTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_selected));
                goodsListSortSaleTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
                goodsListSortPriceTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
            }
        });

        goodsListSortSaleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsListSortSaleTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_selected));
                goodsListSortCommonTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
                goodsListSortPriceTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
            }
        });

        goodsListSortPriceTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsListSortPriceTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_selected));
                goodsListSortSaleTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
                goodsListSortCommonTxt.setBackgroundColor(getResources().getColor(R.color.goods_list_sort_unselected));
            }
        });
    }

}
