package com.example.weather_forecast_app.juhe;
/*
* 聚合数据平台：提供了今日的相关指数信息
* */
public class JHIndexBean {

    /**
     * reason : 查询成功!
     * result : {"city":"深圳","life":{"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"},"shushidu":{"v":"较舒适","des":"白天天气晴好，同时较大的空气湿度，会使您在午后略感闷热，但早晚仍很凉爽、舒适。"},"chuanyi":{"v":"舒适","des":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"diaoyu":{"v":"适宜","des":"白天风和日丽，适宜垂钓，渺渺蓝天，悠悠白云将陪伴你度过愉快的垂钓时光。"},"ganmao":{"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"ziwaixian":{"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"xiche":{"v":"较适宜","des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"yundong":{"v":"适宜","des":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"},"daisan":{"v":"不带伞","des":"天气较好，不会降水，因此您可放心出门，无须带雨伞。"}}}
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
         * life : {"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"},"shushidu":{"v":"较舒适","des":"白天天气晴好，同时较大的空气湿度，会使您在午后略感闷热，但早晚仍很凉爽、舒适。"},"chuanyi":{"v":"舒适","des":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"diaoyu":{"v":"适宜","des":"白天风和日丽，适宜垂钓，渺渺蓝天，悠悠白云将陪伴你度过愉快的垂钓时光。"},"ganmao":{"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"ziwaixian":{"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"xiche":{"v":"较适宜","des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"yundong":{"v":"适宜","des":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"},"daisan":{"v":"不带伞","des":"天气较好，不会降水，因此您可放心出门，无须带雨伞。"}}
         */

        private String city;
        private LifeBean life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public static class LifeBean {
            /**
             * kongtiao : {"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"}
             * guomin : {"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"}
             * shushidu : {"v":"较舒适","des":"白天天气晴好，同时较大的空气湿度，会使您在午后略感闷热，但早晚仍很凉爽、舒适。"}
             * chuanyi : {"v":"舒适","des":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"}
             * diaoyu : {"v":"适宜","des":"白天风和日丽，适宜垂钓，渺渺蓝天，悠悠白云将陪伴你度过愉快的垂钓时光。"}
             * ganmao : {"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
             * ziwaixian : {"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
             * xiche : {"v":"较适宜","des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * yundong : {"v":"适宜","des":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"}
             * daisan : {"v":"不带伞","des":"天气较好，不会降水，因此您可放心出门，无须带雨伞。"}
             */

            private KongtiaoBean kongtiao;
            private GuominBean guomin;
            private ShushiduBean shushidu;
            private ChuanyiBean chuanyi;
            private DiaoyuBean diaoyu;
            private GanmaoBean ganmao;
            private ZiwaixianBean ziwaixian;
            private XicheBean xiche;
            private YundongBean yundong;
            private DaisanBean daisan;

            public KongtiaoBean getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(KongtiaoBean kongtiao) {
                this.kongtiao = kongtiao;
            }

            public GuominBean getGuomin() {
                return guomin;
            }

            public void setGuomin(GuominBean guomin) {
                this.guomin = guomin;
            }

            public ShushiduBean getShushidu() {
                return shushidu;
            }

            public void setShushidu(ShushiduBean shushidu) {
                this.shushidu = shushidu;
            }

            public ChuanyiBean getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(ChuanyiBean chuanyi) {
                this.chuanyi = chuanyi;
            }

            public DiaoyuBean getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(DiaoyuBean diaoyu) {
                this.diaoyu = diaoyu;
            }

            public GanmaoBean getGanmao() {
                return ganmao;
            }

            public void setGanmao(GanmaoBean ganmao) {
                this.ganmao = ganmao;
            }

            public ZiwaixianBean getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(ZiwaixianBean ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public XicheBean getXiche() {
                return xiche;
            }

            public void setXiche(XicheBean xiche) {
                this.xiche = xiche;
            }

            public YundongBean getYundong() {
                return yundong;
            }

            public void setYundong(YundongBean yundong) {
                this.yundong = yundong;
            }

            public DaisanBean getDaisan() {
                return daisan;
            }

            public void setDaisan(DaisanBean daisan) {
                this.daisan = daisan;
            }

            public static class KongtiaoBean {
                /**
                 * v : 较少开启
                 * des : 您将感到很舒适，一般不需要开启空调。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GuominBean {
                /**
                 * v : 极不易发
                 * des : 天气条件极不易诱发过敏，可放心外出，享受生活。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ShushiduBean {
                /**
                 * v : 较舒适
                 * des : 白天天气晴好，同时较大的空气湿度，会使您在午后略感闷热，但早晚仍很凉爽、舒适。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ChuanyiBean {
                /**
                 * v : 舒适
                 * des : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DiaoyuBean {
                /**
                 * v : 适宜
                 * des : 白天风和日丽，适宜垂钓，渺渺蓝天，悠悠白云将陪伴你度过愉快的垂钓时光。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GanmaoBean {
                /**
                 * v : 少发
                 * des : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ZiwaixianBean {
                /**
                 * v : 弱
                 * des : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class XicheBean {
                /**
                 * v : 较适宜
                 * des : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class YundongBean {
                /**
                 * v : 适宜
                 * des : 天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DaisanBean {
                /**
                 * v : 不带伞
                 * des : 天气较好，不会降水，因此您可放心出门，无须带雨伞。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }
    }
}
