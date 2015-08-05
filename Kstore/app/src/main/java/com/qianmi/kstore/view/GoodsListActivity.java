package com.qianmi.kstore.view;

import android.app.Activity;
import android.os.Bundle;

import com.qianmi.kstore.R;

/**
 * Created by 20150622 on 2015/8/1.
 * 商品列表页面的Activity，包含两个Fragment，头部和列表
 */
public class GoodsListActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goos_list);
    }

}
