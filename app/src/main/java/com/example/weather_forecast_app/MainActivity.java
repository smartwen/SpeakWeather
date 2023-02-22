package com.example.weather_forecast_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.weather_forecast_app.city_manager.CityManagerActivity;
import com.example.weather_forecast_app.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView addCityIv,moreIv;
    LinearLayout pointLayout;
    RelativeLayout outLayout;
    ViewPager mainVp;
    
    //ViewPager的数据源
    List<Fragment> fragmentList;
    //表示需要显示的城市的集合
    List<String> cityList;
    //表示ViewPager的页数指示器显示集合
    List<ImageView> imgList;
    private CityFragmentPagerAdapter adapter;
    private SharedPreferences pref;
    private int bgNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCityIv  = findViewById(R.id.main_iv_add);
        moreIv = findViewById(R.id.main_iv_more);
        pointLayout = findViewById(R.id.main_layout_point);
        outLayout = findViewById(R.id.main_out_layout);
        mainVp = findViewById(R.id.main_vp);

        exchangeBg();
        addCityIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        
        fragmentList = new ArrayList<>();
        imgList = new ArrayList<>();

        cityList = DBManager.queryAllCityName();
        if (cityList.size()==0){
            cityList.add("北京");
            cityList.add("上海");
        }

        //因为可能搜索界面点击跳转此界面，会传值，所以此处获取一下
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        //第一次进入不是搜索界面进来的 city如果是空就不加入
        if (!cityList.contains(city) && !TextUtils.isEmpty(city)){
            cityList.add(city);
        }
        
        //初始化viewPager页面的方法
        initPager();
        adapter = new CityFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        mainVp.setAdapter(adapter);
        //创建小圆点指示器
        initPoint();
        //设置最后一个城市信息
        mainVp.setCurrentItem(fragmentList.size()-1);
        //设置viewPager页面监听
        setPageListener();
    }

    //换壁纸的函数
    public void exchangeBg(){
        pref = getSharedPreferences("bg_pref",MODE_PRIVATE);
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

    private void setPageListener() {
        //设置监听事件
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<imgList.size();i++){
                    imgList.get(i).setImageResource(R.mipmap.a1);//没有选择当前界面显示白色小圆圈
                }
                imgList.get(position).setImageResource(R.mipmap.a2);//选择当前页面显示绿色小圆圈
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initPoint() {
        //创建小圆点 viewPager页面显示器的函数
        for (int i=0;i<fragmentList.size();i++){
            ImageView plv = new ImageView(this);//设置小圆点对象
            plv.setImageResource(R.mipmap.a1);
            plv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            //设置外边距
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) plv.getLayoutParams();
            lp.setMargins(0,0,20,0);
            imgList.add(plv);
            pointLayout.addView(plv);
        }
        imgList.get(imgList.size()-1).setImageResource(R.mipmap.a2);//app启动时默认显示list里最后一个城市信息

    }

    private void initPager() {
        /* 创建Fragment对象，添加到ViewPager数据源当中*/
        for (int i = 0; i < cityList.size(); i++) {
            CityWeatherFragment cwFrag = new CityWeatherFragment();
            Bundle bundle = new Bundle();
            bundle.putString("city",cityList.get(i));
            cwFrag.setArguments(bundle);
            fragmentList.add(cwFrag);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.main_iv_add:
                intent.setClass(this, CityManagerActivity.class);
                break;

            case R.id.main_iv_more:
                intent.setClass(this, MoreActivity.class);
                break;
        }
        startActivity(intent);
    }

    /**
     * 当页面重新加载时会调用的函数,函数会在页面获取焦点之前进行调用，此处完成ViewPager页数的更新
     * */
    @Override
    protected void onRestart(){
        super.onRestart();
        List<String> cityList2 = DBManager.queryAllCityName();
        if (cityList2.size() == 0){
            cityList2.add("北京");
        }
        cityList.clear();//重新加载之前，清空原来的数据源
        cityList.addAll(cityList2);
        //剩余城市也需要创建对应的Fragment页面
        fragmentList.clear();
        initPager();

        adapter.notifyDataSetChanged();
        // 页面数量发生改变  指示器的数量也会发生变化重写设置添加指示器
        imgList.clear();
        pointLayout.removeAllViews();
        initPoint();
        mainVp.setCurrentItem(fragmentList.size()-1);
    }

}