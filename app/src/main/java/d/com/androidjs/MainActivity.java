package d.com.androidjs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import d.com.androidjs.linechart.ChartLineView;
import d.com.androidjs.linechart.EchartBean;

public class MainActivity extends AppCompatActivity {
    private ChartLineView analyse_report_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analyse_report_chart = findViewById(R.id.analyse_report_chart);
        //折线图
        analyse_report_chart.createLineChart(EchartBean.getInstance().getAnalyseBusines());
    }
}
