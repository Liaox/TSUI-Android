package com.zhiyicx.tsuidemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhiyicx.tsuidemo.bean.CateBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRv.setLayoutManager(layoutManager);
        List<CateBean> list = new ArrayList<>();
        // Button
        CateBean cateButton = new CateBean();
        cateButton.setTitle("Button");
        list.add(cateButton);
        // EditText
        CateBean cateEditText = new CateBean();
        cateEditText.setTitle("EditText");
        list.add(cateEditText);
        // TextView
        CateBean cateTextView = new CateBean();
        cateTextView.setTitle("TextView");
        list.add(cateTextView);
        MyAdapter adapter = new MyAdapter(this, list);
        mRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, TSButtonActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, TSEditTextActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, TSTextViewActivity.class);
                        startActivity(intent2);
                        break;
                    default:
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private class MyAdapter extends CommonAdapter<CateBean>{

        public MyAdapter(Context context, List<CateBean> datas) {
            super(context, R.layout.item_cate, datas);
        }

        @Override
        protected void convert(ViewHolder holder, CateBean cateBean, int position) {
            holder.setText(R.id.tv_title, cateBean.getTitle());
        }
    }

}
