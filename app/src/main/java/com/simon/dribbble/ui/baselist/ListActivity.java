package com.simon.dribbble.ui.baselist;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.simon.agiledevelop.mvpframe.BaseActivity;
import com.simon.agiledevelop.mvpframe.BaseFragment;
import com.simon.agiledevelop.mvpframe.Presenter;
import com.simon.agiledevelop.state.StateView;
import com.simon.dribbble.R;
import com.simon.dribbble.ui.shots.AttachmentFragment;
import com.simon.dribbble.ui.shots.BucketsFragment;
import com.simon.dribbble.ui.shots.LikesFragment;

/**
 * Created by: Simon
 * Email: simon.han0220@gmail.com
 * Created on: 2016/9/13 18:00
 */

public class ListActivity extends BaseActivity {

    private BaseFragment mFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_comm;
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    protected StateView getLoadingView() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("列表数据");
//        setSupportActionBar(toolbar);
        setCommonBackToolBack(toolbar, "列表数据");

        Bundle bundle = getBundle();
        if (null != bundle) {
            String type = bundle.getString("type");
            long shotId = bundle.getLong("shotId");
            int count = bundle.getInt("count");

            if ("likes".equals(type)) {
                toolbar.setTitle("粉丝(" + count + ")");
                mFragment = LikesFragment.newInstance();
            } else if ("attachments".equals(type)) {
                toolbar.setTitle("附件(" + count + ")");
                mFragment = AttachmentFragment.newInstance();
            } else if ("buckets".equals(type)) {
                toolbar.setTitle("作品集(" + count + ")");
                mFragment = BucketsFragment.newInstance();
            } else {
                mFragment = LikesFragment.newInstance();
            }
            mFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mFragment)
                    .commit();
        }
    }

    @Override
    protected void initEventAndData() {

    }
}
