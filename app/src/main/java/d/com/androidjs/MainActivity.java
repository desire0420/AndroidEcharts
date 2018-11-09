package d.com.androidjs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dianping.chart.activites.TestChartActivity;

import java.util.ArrayList;
import java.util.List;

import d.com.androidjs.jsbridge.JSBridgeActivity;

public class MainActivity extends AppCompatActivity {
    Button jsbridge;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerAdapter mAdapter;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    Button line, pre, chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void setListener() {
        jsbridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JSBridgeActivity.class));
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LineActivity.class));

            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PieActivity.class));

            }
        });
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestChartActivity.class));

            }
        });
    }

    private void findViews() {
        chart = findViewById(R.id.chart);
        line = findViewById(R.id.line);
        pre = findViewById(R.id.pre);
        jsbridge = findViewById(R.id.jsbridge);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mFragmentList.add(new OneFragment());
        mFragmentList.add(new TwoFragment());
        mFragmentList.add(new ThreeFragment());
        mFragmentTitleList.add("第一个");
        mFragmentTitleList.add("第二个");
        mFragmentTitleList.add("第三个");
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Log.w("TAG", "---------" + position);
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
