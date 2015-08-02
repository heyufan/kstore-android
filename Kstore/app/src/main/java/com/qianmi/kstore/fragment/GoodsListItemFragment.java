package com.qianmi.kstore.fragment;

import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianmi.kstore.R;
import com.qianmi.kstore.task.LoadMoreDataTask;
import com.qianmi.kstore.task.RefreshDataTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 20150622 on 2015/8/2.
 */
public class GoodsListItemFragment extends ListFragment implements ExpandableListView.OnGroupClickListener,PullToRefreshBase.OnRefreshListener {
    private List<Map<String, Object>> mData;
    private MyAdapter adapter;
    private PullToRefreshListView goodsListView;
    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_goods_list, container, false);
        initView();
        setListeners();
        //setListAdapter(adapter);
        return rootView;
    }

    private void initView() {
        goodsListView = (PullToRefreshListView) rootView.findViewById(R.id.goods_list_view);
        mData = getData();
        adapter = new MyAdapter(this.getActivity());
        goodsListView.getRefreshableView().setAdapter(adapter);
        goodsListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

    }

    private void setListeners() {
        //设定下拉监听函数
        goodsListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                String label = DateFormat.format("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis()).toString();
                //设置下拉标签
                goodsListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                //设置释放标签
                goodsListView.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                //设置刷新标签
                goodsListView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                //设置上一次刷新的提示标签
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上一次更新时间:" + label);
                new RefreshDataTask(goodsListView).execute();
            }
        });

        goodsListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (goodsListView.getRefreshableView().getLastVisiblePosition() == (goodsListView.getRefreshableView().getCount() - 1)) {
                            new LoadMoreDataTask(goodsListView,adapter,mData).execute();
                        }
                        // 判断滚动到顶部

                        if(goodsListView.getRefreshableView().getFirstVisiblePosition() == 0){
                        }

                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("goodsName", "G2");
        map.put("goodsPrice", "google 2");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("goodsName", "G3");
        map.put("goodsPrice", "google 3");
        map.put("goodsImg", R.drawable.goods_demo);
        list.add(map);

        return list;
    }

    // ListView 中某项被选中后的逻辑
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showInfo(position);
        Log.v("MyListView4-click", (String) mData.get(position).get("goodsName"));
    }

    /**
     * listview中点击按键弹出对话框
     */
    public void showInfo(int position) {
        new AlertDialog.Builder(this.getActivity())
                .setTitle("我的listview")
                .setMessage((String) mData.get(position).get("goodsName"))
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return false;
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {

    }

    public final class ViewHolder {
        public ImageView goodsImgView;
        public TextView goodsNameText;
        public TextView goodsPriceText;
        public Button viewBtn;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {

                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.goods_list_item, null);

                holder.goodsImgView = (ImageView) convertView.findViewById(R.id.goods_list_goods_img);
                holder.goodsNameText = (TextView) convertView.findViewById(R.id.goods_list_goods_name);
                holder.goodsPriceText = (TextView) convertView.findViewById(R.id.goods_list_goods_price);
                //holder.viewBtn = (Button) convertView.findViewById(R.id.view_btn);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }


            holder.goodsImgView.setBackgroundResource((Integer) mData.get(position).get("goodsImg"));
            holder.goodsNameText.setText((String) mData.get(position).get("goodsName"));
            holder.goodsPriceText.setText((String) mData.get(position).get("goodsPrice"));

            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showInfo(position);
                }
            });


            return convertView;
        }

    }





}
