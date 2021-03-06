package com.qianmi.kstore.task;

import android.os.AsyncTask;
import android.widget.EditText;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 20150622 on 2015/8/2.
 * 重新加载第一页数据，然后刷新列表
 */
public class RefreshDataTask extends AsyncTask<Void, Void, HashMap<String, Object>> {
    private PullToRefreshListView refreshListView;
    private Map<String,Object> paraMap;
    public RefreshDataTask() {}

    public RefreshDataTask(PullToRefreshListView refreshListView,Map<String,Object> paraMap) {
        this.refreshListView = refreshListView;
        this.paraMap = paraMap;
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
        System.out.println("searchText====================="+paraMap.get("searchTitle"));
        return map;
    }

    //这里是对刷新的响应，可以利用addFirst（）和addLast()函数将新加的内容加到LISTView中
    //根据AsyncTask的原理，onPostExecute里的result的值就是doInBackground()的返回值
    @Override
    protected void onPostExecute(HashMap<String, Object> result) {
        //在头部增加新添内容

        try {
                /*mData.add(result);

                //通知程序数据集已经改变，如果不做通知，那么将不会刷新mListItems的集合
                adapter.notifyDataSetChanged();*/
            // Call onRefreshComplete when the list has been refreshed.
            refreshListView.onRefreshComplete();
        } catch (Exception e) {
            // TODO: handle exception
            //setTitle(e.getMessage());
        }
        super.onPostExecute(result);
    }
}