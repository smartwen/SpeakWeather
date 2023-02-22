package com.example.weather_forecast_app.juhe;

import java.util.List;

public class JHTempBean {

    //打开网站https://www.juhe.cn/docs/api/id/73
    //2.拷贝json返回代码 将数据拷贝 来到android studio(前提：已安装gsonFormat)
    //3.点击Generate 选择Gsonformat 自动生成如下数据
    //4.聚合天气平台提供最近5天天气情况
    //5.聚合 个人账户OpenId：JHf893da3d8d59b90a9471e32c1a1e3b43

    /**
     *请求地址：http://apis.juhe.cn/simpleWeather/query
     * 请求参数：city=%E6%B7%B1%E5%9C%B3&key=49b90e15******a57521bb
     * 请求方式：GET
     * Header：
     *    Content-Type：application/x-www-form-urlencoded
     * */


    /**
     * reason : 查询成功!
     * result : {"city":"深圳","realtime":{"temperature":"23","humidity":"78","info":"多云","wid":"01","direct":"东风","power":"4级","aqi":"20"},"future":[{"date":"2023-02-12","temperature":"20/25℃","weather":"多云转阴","wid":{"day":"01","night":"02"},"direct":"持续无风向"},{"date":"2023-02-13","temperature":"14/26℃","weather":"多云转小雨","wid":{"day":"01","night":"07"},"direct":"持续无风向"},{"date":"2023-02-14","temperature":"13/19℃","weather":"阵雨转多云","wid":{"day":"03","night":"01"},"direct":"持续无风向"},{"date":"2023-02-15","temperature":"12/20℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风"},{"date":"2023-02-16","temperature":"13/21℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风转东风"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * city : 深圳
         * realtime : {"temperature":"23","humidity":"78","info":"多云","wid":"01","direct":"东风","power":"4级","aqi":"20"}
         * future : [{"date":"2023-02-12","temperature":"20/25℃","weather":"多云转阴","wid":{"day":"01","night":"02"},"direct":"持续无风向"},{"date":"2023-02-13","temperature":"14/26℃","weather":"多云转小雨","wid":{"day":"01","night":"07"},"direct":"持续无风向"},{"date":"2023-02-14","temperature":"13/19℃","weather":"阵雨转多云","wid":{"day":"03","night":"01"},"direct":"持续无风向"},{"date":"2023-02-15","temperature":"12/20℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风"},{"date":"2023-02-16","temperature":"13/21℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风转东风"}]
         */

        private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class RealtimeBean {
            /**
             * temperature : 23
             * humidity : 78
             * info : 多云
             * wid : 01
             * direct : 东风
             * power : 4级
             * aqi : 20
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureBean {
            /**
             * date : 2023-02-12
             * temperature : 20/25℃
             * weather : 多云转阴
             * wid : {"day":"01","night":"02"}
             * direct : 持续无风向
             */

            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidBean getWid() {
                return wid;
            }

            public void setWid(WidBean wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidBean {
                /**
                 * day : 01
                 * night : 02
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }


}
