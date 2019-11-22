package com.mycompany.news.ui;

import androidx.fragment.app.Fragment;
import com.mycompany.news.AppDelegate;
import com.mycompany.news.common.SingleFragmentActivity;
import com.mycompany.news.data.Storage;

public class NewsActivity extends SingleFragmentActivity implements Storage.StorageOwner {

    @Override
    protected Fragment getFragment() {
        return NewsFragment.newInstance();
    }

    @Override
    public Storage obtainStorage() {
        return ((AppDelegate) getApplicationContext()).getStorage();
    }

}
