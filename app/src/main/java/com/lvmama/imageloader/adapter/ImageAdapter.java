package com.lvmama.imageloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lvmama.imageloader.R;
import com.lvmama.imageloader.customview.SquareImageView;
import com.lvmama.imageloader.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2016/4/27.
 */
public class ImageAdapter extends BaseAdapter {
    private List<String> mUrlList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ImageLoader mImageLoader;

    private boolean mIsGridViewVisible = true;

    public boolean ismIsGridViewVisible() {
        return mIsGridViewVisible;
    }

    public void setmIsGridViewVisible(boolean mIsGridViewVisible) {
        this.mIsGridViewVisible = mIsGridViewVisible;
    }

    public ImageAdapter(Context context, List<String> data) {
        this.mUrlList = data;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        mImageLoader = ImageLoader.build(context);
    }

    @Override
    public int getCount() {
        return mUrlList.size();
    }

    @Override
    public String getItem(int position) {
        return mUrlList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_img, parent, false);
            holder = new ViewHolder();
            holder.imageView = (SquareImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageView imageView = holder.imageView;
        final String tag = (String) imageView.getTag();
        final String uri = getItem(position);
        if (!uri.equals(tag)) {
            imageView.setImageResource(R.mipmap.default_img);
        }
        if (mIsGridViewVisible) {
            imageView.setTag(uri);
            mImageLoader.bindBitmap(uri, imageView, imageView.getWidth(), imageView.getWidth());
        }

        return convertView;
    }

    private static class ViewHolder {
        public SquareImageView imageView;
    }
}
