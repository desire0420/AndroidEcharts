package d.com.androidjs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d.com.androidjs.linechart.ChartLineView;
import d.com.androidjs.linechart.EchartBean;

public class TwoFragment  extends LazyFragment {

    View mRootView;
    private ChartLineView analyse_report_chart;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_demo, container, false);
        analyse_report_chart = mRootView.findViewById(R.id.analyse_report_chart);
        //折线图
        return mRootView;
    }

    @Override
    protected void initData() {
        analyse_report_chart.createLineChart(EchartBean.getInstance().getTwo());

    }



}
