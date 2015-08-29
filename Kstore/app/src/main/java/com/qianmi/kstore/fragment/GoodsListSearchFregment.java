package com.qianmi.kstore.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianmi.kstore.R;
import com.qianmi.kstore.task.RefreshDataTask;

import java.util.HashMap;
import java.util.Map;

import mehdi.sakout.dynamicbox.DynamicBox;

/**
 * Created by 20150622 on 2015/8/29.
 */
public class GoodsListSearchFregment extends Fragment {
    private TextView backTextView = null;
    private EditText searchTextView = null;
    DynamicBox box = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_search, container, false);
        initView(view);
        bindOnclickListener();
        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        backTextView = (TextView) view.findViewById(R.id.text_goods_list_back);
        searchTextView = (EditText) view.findViewById(R.id.text_goods_list_search);
    }

    /**
     * 绑定监听
     */
    private void bindOnclickListener() {
        backTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        searchTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Map<String,Object> paraMap = new HashMap<String, Object>();
                paraMap.put("searchTitle", searchTextView.getText());
                //PullToRefreshListView goodsListView = (PullToRefreshListView) getActivity().findViewById(R.id.goods_list_view);
                if(box==null) {
                    box = new DynamicBox(getActivity(),getActivity().findViewById(R.id.id_goods_list_activity));
                    box.setLoadingMessage("正在加载。。。");
                }
                myHeavyWork();
                //new RefreshDataTask(goodsListView,paraMap).execute();
                return true;
            }
        });
    }

    private void myHeavyWork(){

        box.showLoadingLayout();

        // Wait 2 seconds before showing result
        new Handler().postDelayed(new Runnable() {
            public void run() {
                box.hideAll();
            }
        }, 1000);

    }
}
