package d.com.androidjs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import d.com.androidjs.linechart.ChartLineView;
import d.com.androidjs.linechart.EchartBean;

/**
 * Created by wangwei on 2018/10/23.
 */

public class LineActivity extends AppCompatActivity {
    private ChartLineView chartView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        chartView = findViewById(R.id.analyse_report_chart);
        chartView.createLineChart(EchartBean.getInstance().getOne());

    }
}
