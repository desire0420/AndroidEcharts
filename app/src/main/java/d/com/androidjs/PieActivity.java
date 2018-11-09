package d.com.androidjs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import d.com.androidjs.linechart.ChartLineView;
import d.com.androidjs.linechart.ChartPieView;
import d.com.androidjs.linechart.EchartBean;

/**
 * Created by wangwei on 2018/10/23.
 */

public class PieActivity extends AppCompatActivity {
    private ChartPieView chartView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pie);
        chartView = findViewById(R.id.pie_chart);
        chartView.createPieChart(EchartBean.getInstance().getOne());

    }
}
