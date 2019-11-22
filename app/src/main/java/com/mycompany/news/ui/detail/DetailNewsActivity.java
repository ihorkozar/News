package com.mycompany.news.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.mycompany.news.AppDelegate;
import com.mycompany.news.common.SingleFragmentActivity;
import com.mycompany.news.data.Storage;

public class DetailNewsActivity extends SingleFragmentActivity implements Storage.StorageOwner {
    public static final String USERNAME_KEY = "USERNAME_KEY";

    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return DetailNewsFragment.newInstance(getIntent().getBundleExtra(USERNAME_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null");
    }

    @Override
    public Storage obtainStorage() {
        return ((AppDelegate) getApplicationContext()).getStorage();
    }

}
