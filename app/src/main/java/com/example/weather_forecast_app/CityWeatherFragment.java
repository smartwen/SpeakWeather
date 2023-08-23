package com.example.weather_forecast_app;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.weather_forecast_app.base.BaseFragment;
import com.example.weather_forecast_app.db.DBManager;
import com.example.weather_forecast_app.juhe.HttpUtils;
import com.example.weather_forecast_app.juhe.JHIndexBean;
import com.example.weather_forecast_app.juhe.JHTempBean;
import com.example.weather_forecast_app.juhe.URLUtils;
import com.google.gson.Gson;

import org.xutils.DbManager;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;


///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CityWeatherFragment#newInstance} factory method to
// * create an instance of this fragment.
// https://www.juhe.cn/ 聚合天气API
//  https://dashboard.juhe.cn/data/index/my 请求Key：49b90e15ea4857dbeb607bf4a57521bb
// */
public class CityWeatherFragment extends BaseFragment implements View.OnClickListener{
    TextView tempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,carIndexTv,
            coldIndexTv,sportIndexTv,raysIndexTv,airIndexTv;
    ImageView dayIv;
    LinearLayout futureLayout;
    JHIndexBean.ResultBean.LifeBean lifeBean;    //指数信息
    String city;
    ScrollView outLayout;
    private SharedPreferences pref;
    private int bgNum;

    //从其他API进行获取天气数据 存储导当前编写的APP中


    public CityWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =
         inflater.inflate(R.layout.fragment_city_weather, container, false);
        initView(view);
        exchangeBg();
        //可以通过activity传值获取当前fragment加载的是哪个地方的天气情况
        Bundle bundle = getArguments();
         city = bundle.getString("city");
        String tempUrl = URLUtils.getTemp_url(city);
        //加载数据的过程提出来，缩小代码量 提到父类当中BaseFragment
        loadData(tempUrl);
        // 获取指数信息的网址
        String index_url = URLUtils.getIndex_url(city);
        loadIndexData(index_url);
        return view;
    }

    //        换壁纸的函数
    public void exchangeBg(){
        pref = getActivity().getSharedPreferences("bg_pref", MODE_PRIVATE);
        bgNum = pref.getInt("bg", 2);
        switch (bgNum) {
            case 0:
                outLayout.setBackgroundResource(R.mipmap.bg);
                break;
            case 1:
                outLayout.setBackgroundResource(R.mipmap.bg2);
                break;
            case 2:
                outLayout.setBackgroundResource(R.mipmap.bg3);
                break;
        }

    }

   /* 网络获取指数信息*/
    private void loadIndexData(final String index_url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = HttpUtils.getJsonContent(index_url);
                JHIndexBean jhIndexBean = new Gson().fromJson(json, JHIndexBean.class);
                if (jhIndexBean.getResult()!=null) {
                    lifeBean = jhIndexBean.getResult().getLife();
                }
            }
        }).start();
    }

    private void parseShowData(String result) {
        //使用Gson解析数据
        JHTempBean jhTemBean = new Gson().fromJson(result, JHTempBean.class);
        JHTempBean.ResultBean jhResult = jhTemBean.getResult();
        // 设置TextView
        dateTv.setText(jhResult.getFuture().get(0).getDate());
        cityTv.setText(jhResult.getCity());
//        获取今日天气情况
        JHTempBean.ResultBean.FutureBean jhTodayFuture = jhResult.getFuture().get(0);
        JHTempBean.ResultBean.RealtimeBean jhRealtime = jhResult.getRealtime();

        windTv.setText(jhRealtime.getDirect() + jhRealtime.getPower());
        tempRangeTv.setText(jhTodayFuture.getTemperature());
        conditionTv.setText(jhRealtime.getInfo());
//     获取实时天气温度情况
        tempTv.setText(jhRealtime.getTemperature() + "℃");

//        获取未来三天的天气情况，加载到layout当中
        List<JHTempBean.ResultBean.FutureBean> futureList = jhResult.getFuture();
        futureList.remove(0);
        for (int i = 0; i < futureList.size(); i++) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center, null);
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            futureLayout.addView(itemView);
            TextView idateTv = itemView.findViewById(R.id.item_center_tv_date);
            TextView iconTv = itemView.findViewById(R.id.item_center_tv_con);
            TextView windTv = itemView.findViewById(R.id.item_center_tv_wind);
            TextView itemprangeTv = itemView.findViewById(R.id.item_center_tv_temp);
            // ImageView iIv = itemView.findViewById(R.id.item_center_iv);
//          获取对应的位置的天气情况
            JHTempBean.ResultBean.FutureBean dataBean = futureList.get(i);
            idateTv.setText(dataBean.getDate());
            iconTv.setText(dataBean.getWeather());
            itemprangeTv.setText(dataBean.getTemperature());
            windTv.setText(dataBean.getDirect());
        }
    }

    //用到了面向对象里多态的知识
    @Override
    public void onSuccess(String result){
        //解析并展示数据
       parseShowData(result);
       //更新数据
        int i = DBManager.updateInfoByCity(city,result);
        if (i<=0){
//            更新数据失败，没有这个城市信息，增加这个城市记录
            DBManager.addCityInfo(city,result);

        }
    }

    @Override
    public void onError(Throwable ex,boolean isOnCallback){
        super.onError(ex,isOnCallback);
//        数据库当中查找上一次信息显示在Fragment当中
        String  s = DBManager.queryInfoByCity(city);
        if (!TextUtils.isEmpty(s)){
            parseShowData(s);
        }
    }



    private void initView(View view) {
        tempTv = view.findViewById(R.id.frag_tv_currenttemp);
        cityTv = view.findViewById(R.id.frag_tv_city);
        conditionTv = view.findViewById(R.id.frag_tv_condition);
        dateTv = view.findViewById(R.id.frag_tv_date);
        windTv = view.findViewById(R.id.frag_tv_wind);
        tempRangeTv = view.findViewById(R.id.frag_tv_temprange);
        dayIv = view.findViewById(R.id.frag_iv_today);//说天气右上角图标icon

        clothIndexTv = view.findViewById(R.id.frag_index_tv_dress);
        carIndexTv = view.findViewById(R.id.frag_index_tv_washcar);
        coldIndexTv = view.findViewById(R.id.frag_index_tv_cold);
        sportIndexTv = view.findViewById(R.id.frag_index_tv_sport);
        raysIndexTv = view.findViewById(R.id.frag_index_tv_rays);
        airIndexTv = view.findViewById(R.id.frag_index_tv_air);


        futureLayout = view.findViewById(R.id.frag_center_layout);//用于显示未来三天天气情况
        outLayout = view.findViewById(R.id.out_layout);


        clothIndexTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTv.setOnClickListener(this);
        airIndexTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (v.getId()){
            case R.id.frag_index_tv_dress:
                builder.setTitle("穿衣指数");
                String msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getChuanyi().getV()+"\n"+lifeBean.getChuanyi().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_washcar:
                builder.setTitle("洗车指数");
                msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getXiche().getV()+"\n"+lifeBean.getXiche().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_cold:
                builder.setTitle("感冒指数");
                msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getGanmao().getV()+"\n"+lifeBean.getGanmao().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_sport:
                builder.setTitle("运动指数");
                msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getYundong().getV()+"\n"+lifeBean.getYundong().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_rays:
                builder.setTitle("紫外线指数");
                msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getZiwaixian().getV()+"\n"+lifeBean.getZiwaixian().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_air:
                builder.setTitle("空调指数");
                msg = "暂无信息";
                if (lifeBean!=null){
                    msg = lifeBean.getKongtiao().getV()+"\n"+lifeBean.getKongtiao().getDes();
                }
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
        }
        builder.create().show();

    }
}
