package com.mycompany.news.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mycompany.news.R;

public abstract class RefreshActivity extends SingleFragmentActivity
        implements SwipeRefreshLayout.OnRefreshListener, RefreshOwner {
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeRefreshLayout = findViewById(R.id.refresher);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof Refreshable) {
            ((Refreshable) fragment).onRefreshData();
        } else {
            setRefreshState(false);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_swipe_container;
    }

    @Override
    public void setRefreshState(boolean refreshing) {
        swipeRefreshLayout.post(() -> swipeRefreshLayout.setRefreshing(refreshing));
        //swipeRefreshLayout.post(() -> swipeRefreshLayout.setRefreshing(refreshing));
    }

}
