package com.qianmi.kstore.task;

import android.os.AsyncTask;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianmi.kstore.R;
import com.qianmi.kstore.fragment.GoodsListItemFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 20150622 on 2015/8/2.
 * 加载更多数据，然后刷新列表
 */
public class LoadMoreDataTask extends AsyncTask<Void, Void, HashMap<String, Object>> {
    private PullToRefreshListView refreshListView;
    private GoodsListItemFragment.MyAdapter adapter;
    private List<Map<String, Object>> mData;
    public LoadMoreDataTask() {}
    public LoadMoreDataTask(PullToRefreshListView refreshListView, GoodsListItemFragment.MyAdapter adapter, List<Map<String, Object>> mData) {
        this.refreshListView = refreshListView;
        this.adapter = adapter;
        this.mData = mData;
    }

    //后台处理部分
    @Override
    protected HashMap<String, Object> doInBackground(Void... params) {
        // Simulates a background job.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("goodsName", "精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤精品男装短裤潮流韩版七分裤");
        map.put("goodsPrice", "12.99");
        map.put("goodsImg", R.drawable.goods_demo);
        return map;
    }

    //这里是对刷新的响应，可以利用addFirst（）和addLast()函数将新加的内容加到LISTView中
    //根据AsyncTask的原理，onPostExecute里的result的值就是doInBackground()的返回值
    @Override
    protected void onPostExecute(HashMap<String, Object> result) {
        //在头部增加新添内容

        try {
            mData.add(result);
            //通知程序数据集已经改变，如果不做通知，那么将不会刷新mListItems的集合
            adapter.notifyDataSetChanged();
            // Call onRefreshComplete when the list has been refreshed.
            refreshListView.onRefreshComplete();
        } catch (Exception e) {
            // TODO: handle exception
            //setTitle(e.getMessage());
        }
        super.onPostExecute(result);
    }
}
