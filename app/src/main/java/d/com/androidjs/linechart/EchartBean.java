package d.com.androidjs.linechart;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangwei on 2017/12/20.
 * 对chart需要的数据进行封装
 */

public class EchartBean {
    private static EchartBean echartsDataBean;

    private EchartBean() {
    }

    public synchronized static EchartBean getInstance() {
        if (echartsDataBean == null) {
            echartsDataBean = new EchartBean();
        }
        return echartsDataBean;
    }

    //数据
    public JSONObject getOne() {
        //对数据封装处理
        JSONArray xAxis = new JSONArray(); //保存数组数据的JSONArray对象
        JSONArray yAxis = new JSONArray();
        for (int i = 0; i <7; i++) {
            yAxis.put(i);
            xAxis.put(i);
        }
        JSONObject json = new JSONObject();
        try {
            json.put("name", "one");
            json.put("color", "#4984EF");
            json.put("shadowcolor", "rgba(74,129,236,0.1)");
            json.put("data", yAxis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray series = new JSONArray();
        series.put(json);
        JSONObject result = new JSONObject();
        try {
            result.put("unit", "单位(元)");
            result.put("needFormat", false);
            result.put("showTitle", true);
            result.put("xAxis", xAxis);
            result.put("series", series);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.w("chart", "--" + result);
        return result;
    }

    //数据
    public JSONObject getTwo() {
        //对数据封装处理
        JSONArray xAxis = new JSONArray(); //保存数组数据的JSONArray对象
        JSONArray yAxis = new JSONArray();
        for (int i = 0; i < 7; i++) {
            yAxis.put(i * i);
            xAxis.put(i);
        }
        JSONObject json = new JSONObject();
        try {
            json.put("name", "two");
            json.put("color", "#dd3434");
            json.put("shadowcolor", "rgba(74,129,236,0.1)");
            json.put("data", yAxis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray series = new JSONArray();
        series.put(json);
        JSONObject result = new JSONObject();
        try {
            result.put("unit", "单位(元)");
            result.put("needFormat", false);
            result.put("showTitle", true);
            result.put("xAxis", xAxis);
            result.put("series", series);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.w("chart", "--" + result);
        return result;
    }
    //数据
    public JSONObject getThree() {
        //对数据封装处理
        JSONArray xAxis = new JSONArray(); //保存数组数据的JSONArray对象
        JSONArray yAxis = new JSONArray();
        for (int i = 0; i < 7; i++) {
            yAxis.put(i * i*i);
            xAxis.put(i);
        }
        JSONObject json = new JSONObject();
        try {
            json.put("name", "营业额");
            json.put("color", "#4984EF");
            json.put("shadowcolor", "rgba(74,129,236,0.1)");
            json.put("data", yAxis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray series = new JSONArray();
        series.put(json);
        JSONObject result = new JSONObject();
        try {
            result.put("unit", "单位(元)");
            result.put("needFormat", false);
            result.put("showTitle", true);
            result.put("xAxis", xAxis);
            result.put("series", series);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.w("chart", "--" + result);
        return result;
    }
}
