package com.hotbitmapgg.bilibili.module.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotbitmapgg.bilibili.base.RxBaseActivity;
import com.hotbitmapgg.bilibili.module.common.MainActivity;
import com.hotbitmapgg.ohmybilibili.R;

import butterknife.BindView;


/**
 * RecyclerView下拉刷新、上拉加载更多
 * Created by yangle on 2017/10/12.
 * <p>
 * Website：http://www.yangle.tech
 * <p>
 * GitHub：https://github.com/alidili
 * <p>
 * CSDN：http://blog.csdn.net/kong_gu_you_lan
 * <p>
 * JianShu：http://www.jianshu.com/u/34ece31cd6eb
 */

public class TestActivity extends RxBaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("test");
        setSupportActionBar(toolbar);

    }

    public void btnClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_base:
                intent = new Intent(this, LoadMoreActivity.class);
                break;

            case R.id.btn_wrapper:
                intent = new Intent(this, LoadMoreWrapperActivity.class);
                break;

            case R.id.btn_main:
                intent = new Intent(this, MainActivity.class);
                break;

            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }


}
