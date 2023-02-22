package com.example.weather_forecast_app.juhe;

public class URLUtils {
    public static  final String KEY = "49b90e15ea4857dbeb607bf4a57521bb";
    // 天气情况查询接口地址
    public static String temp_url = "http://apis.juhe.cn/simpleWeather/query";
    public static String INDEX_URL = "http://apis.juhe.cn/simpleWeather/life";
    public static String index_url = "http://apis.juhe.cn/simpleWeather/life";


    public static String getTemp_url(String city){
        String url = temp_url+"?city="+city+"&key="+KEY;
        return url;
    }

    public static String getIndex_url(String city){
        String url = index_url+"?city="+city+"&key="+KEY;
        return url;
    }



}
