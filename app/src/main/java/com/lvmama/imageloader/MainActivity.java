package com.lvmama.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;

import com.lvmama.imageloader.adapter.ImageAdapter;
import com.lvmama.imageloader.imageloader.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private ImageAdapter mImageAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("http://banbao.chazidian.com/uploadfile/2016-01-25/s145368924044608.jpg");
        mData.add("http://pic36.nipic.com/20131217/6704106_233034463381_2.jpg");
    }

    private void initView() {
        mGridView = (GridView) findViewById(R.id.gridview);
        mImageAdapter = new ImageAdapter(MainActivity.this, mData);
        mGridView.setAdapter(mImageAdapter);
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    mImageAdapter.setmIsGridViewVisible(true);
                    mImageAdapter.notifyDataSetChanged();
                } else {
                    mImageAdapter.setmIsGridViewVisible(false);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
