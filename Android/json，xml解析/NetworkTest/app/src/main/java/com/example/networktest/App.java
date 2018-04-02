package com.example.networktest;

import java.util.List;

public class App {


    /**
     * message : success
     * data : {"has_more":true,"total":160,"comments":[{"text":"我最尊重军人和老师，但不是每个人都是好人。也有极少的坏人[发怒]","digg_count":70,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512101670,"user":{"avatar_url":"https://p1.pstatp.com/thumb/3795/3044413937","user_id":3092133937,"name":"手机用户3092133937"},"dongtai_id":1585553520785421,"user_digg":0,"id":1585553520785421},{"text":"这几位家长脑子却筋啊，那自己孩子的清誉搏眼球。如果硬盘没坏，非得把他们抓起来。[撇嘴]","digg_count":51,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512102713,"user":{"avatar_url":"https://p3.pstatp.com/thumb/ef3000d500b94e39fde","user_id":8760970514,"name":"君子讲理痞子骂街"},"dongtai_id":1585554613883918,"user_digg":0,"id":1585554613883918},{"text":"不希望军人被诋毁，但是更不希望孩子受到伤害，因为相比而言，孩子更加弱小与无助。所以，军人，既然我们给予你尊重，请你们保护好我们国家的明天与希望。","digg_count":39,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512103036,"user":{"avatar_url":"https://p3.pstatp.com/thumb/24980008e0e1cb54cbc0","user_id":5491980919,"name":"点点56775847"},"dongtai_id":1585554953162782,"user_digg":0,"id":1585554953162782},{"text":"不要把个别人代表军队","digg_count":37,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512102113,"user":{"avatar_url":"https://p0.pstatp.com/origin/3795/3047680722","user_id":5568961528,"name":"手机用户5568961528"},"dongtai_id":1585553984798733,"user_digg":0,"id":1585553984798733},{"text":"真像真的在我们眼前吗，那么小的孩子会撒谎吗","digg_count":147,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512098880,"user":{"avatar_url":"https://wx.qlogo.cn/mmopen/PiajxSqBRaELZgDpGPSZvCJx40DibYCkL7YCBnkVciaibhkGtW0Vwnj3VXJzUibzibYjKwibMNNtXfzJhs1ZgjNpyxFHLgeGiaI8DA0xVeMLicaHLuGU/64","user_id":4263225959,"name":"用户36794737"},"dongtai_id":1585550595167245,"user_digg":0,"id":1585550595167245},{"text":"拿出有力的证据来，自然不会有诋毁军人的谣言了","digg_count":43,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512100708,"user":{"avatar_url":"https://p9.pstatp.com/thumb/548/3871048219","user_id":3094630047,"name":"五彩雪"},"dongtai_id":1585552511526926,"user_digg":0,"id":1585552511526926},{"text":"每个人都不允许受到任何伤害和诋毁。","digg_count":22,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512103727,"user":{"avatar_url":"https://p1.pstatp.com/thumb/46be00090e6f2e568750","user_id":4570991123,"name":"第七杯coffee1"},"dongtai_id":1585555677801486,"user_digg":0,"id":1585555677801486},{"text":"保护军人名誉，孩子受到伤害也没见怎么弥补和保护啊","digg_count":100,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512098946,"user":{"avatar_url":"https://p9.pstatp.com/thumb/289a0003fd0c49060670","user_id":3424108837,"name":"流浪的毛利"},"dongtai_id":1585550664310798,"user_digg":0,"id":1585550664310798},{"text":"一个是国家的未来，一个是守护国家的未来！这2类人是国家的希望，伤害他们就是伤害国家，可判处叛国罪。","digg_count":65,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512099012,"user":{"avatar_url":"https://p9.pstatp.com/thumb/5329/3194922590","user_id":4610950786,"name":"秋之叶沙之风"},"dongtai_id":1585550733511694,"user_digg":0,"id":1585550733511694},{"text":"有些人就是闲的蛋疼，我就不明白，军人为了你的幸福生活拼死拼活的保卫着你，最脏最累，最危险的事情军人去做了，那些满嘴喷粪的有去做吗","digg_count":49,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512099874,"user":{"avatar_url":"https://p3.pstatp.com/thumb/43d5002051dd964c88ae","user_id":55755175179,"name":"章蓉娅的远方表弟"},"dongtai_id":1585551637279757,"user_digg":0,"id":1585551637279757}]}
     */

    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * has_more : true
         * total : 160
         * comments : [{"text":"我最尊重军人和老师，但不是每个人都是好人。也有极少的坏人[发怒]","digg_count":70,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512101670,"user":{"avatar_url":"https://p1.pstatp.com/thumb/3795/3044413937","user_id":3092133937,"name":"手机用户3092133937"},"dongtai_id":1585553520785421,"user_digg":0,"id":1585553520785421},{"text":"这几位家长脑子却筋啊，那自己孩子的清誉搏眼球。如果硬盘没坏，非得把他们抓起来。[撇嘴]","digg_count":51,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512102713,"user":{"avatar_url":"https://p3.pstatp.com/thumb/ef3000d500b94e39fde","user_id":8760970514,"name":"君子讲理痞子骂街"},"dongtai_id":1585554613883918,"user_digg":0,"id":1585554613883918},{"text":"不希望军人被诋毁，但是更不希望孩子受到伤害，因为相比而言，孩子更加弱小与无助。所以，军人，既然我们给予你尊重，请你们保护好我们国家的明天与希望。","digg_count":39,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512103036,"user":{"avatar_url":"https://p3.pstatp.com/thumb/24980008e0e1cb54cbc0","user_id":5491980919,"name":"点点56775847"},"dongtai_id":1585554953162782,"user_digg":0,"id":1585554953162782},{"text":"不要把个别人代表军队","digg_count":37,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512102113,"user":{"avatar_url":"https://p0.pstatp.com/origin/3795/3047680722","user_id":5568961528,"name":"手机用户5568961528"},"dongtai_id":1585553984798733,"user_digg":0,"id":1585553984798733},{"text":"真像真的在我们眼前吗，那么小的孩子会撒谎吗","digg_count":147,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512098880,"user":{"avatar_url":"https://wx.qlogo.cn/mmopen/PiajxSqBRaELZgDpGPSZvCJx40DibYCkL7YCBnkVciaibhkGtW0Vwnj3VXJzUibzibYjKwibMNNtXfzJhs1ZgjNpyxFHLgeGiaI8DA0xVeMLicaHLuGU/64","user_id":4263225959,"name":"用户36794737"},"dongtai_id":1585550595167245,"user_digg":0,"id":1585550595167245},{"text":"拿出有力的证据来，自然不会有诋毁军人的谣言了","digg_count":43,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512100708,"user":{"avatar_url":"https://p9.pstatp.com/thumb/548/3871048219","user_id":3094630047,"name":"五彩雪"},"dongtai_id":1585552511526926,"user_digg":0,"id":1585552511526926},{"text":"每个人都不允许受到任何伤害和诋毁。","digg_count":22,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512103727,"user":{"avatar_url":"https://p1.pstatp.com/thumb/46be00090e6f2e568750","user_id":4570991123,"name":"第七杯coffee1"},"dongtai_id":1585555677801486,"user_digg":0,"id":1585555677801486},{"text":"保护军人名誉，孩子受到伤害也没见怎么弥补和保护啊","digg_count":100,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512098946,"user":{"avatar_url":"https://p9.pstatp.com/thumb/289a0003fd0c49060670","user_id":3424108837,"name":"流浪的毛利"},"dongtai_id":1585550664310798,"user_digg":0,"id":1585550664310798},{"text":"一个是国家的未来，一个是守护国家的未来！这2类人是国家的希望，伤害他们就是伤害国家，可判处叛国罪。","digg_count":65,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512099012,"user":{"avatar_url":"https://p9.pstatp.com/thumb/5329/3194922590","user_id":4610950786,"name":"秋之叶沙之风"},"dongtai_id":1585550733511694,"user_digg":0,"id":1585550733511694},{"text":"有些人就是闲的蛋疼，我就不明白，军人为了你的幸福生活拼死拼活的保卫着你，最脏最累，最危险的事情军人去做了，那些满嘴喷粪的有去做吗","digg_count":49,"reply_data":{"reply_list":[]},"reply_count":0,"create_time":1512099874,"user":{"avatar_url":"https://p3.pstatp.com/thumb/43d5002051dd964c88ae","user_id":55755175179,"name":"章蓉娅的远方表弟"},"dongtai_id":1585551637279757,"user_digg":0,"id":1585551637279757}]
         */

        private boolean has_more;
        private int total;
        private List<CommentsBean> comments;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            /**
             * text : 我最尊重军人和老师，但不是每个人都是好人。也有极少的坏人[发怒]
             * digg_count : 70
             * reply_data : {"reply_list":[]}
             * reply_count : 0
             * create_time : 1512101670
             * user : {"avatar_url":"https://p1.pstatp.com/thumb/3795/3044413937","user_id":3092133937,"name":"手机用户3092133937"}
             * dongtai_id : 1585553520785421
             * user_digg : 0
             * id : 1585553520785421
             */

            private String text;
            private int digg_count;
            private ReplyDataBean reply_data;
            private int reply_count;
            private int create_time;
            private UserBean user;
            private long dongtai_id;
            private int user_digg;
            private long id;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public ReplyDataBean getReply_data() {
                return reply_data;
            }

            public void setReply_data(ReplyDataBean reply_data) {
                this.reply_data = reply_data;
            }

            public int getReply_count() {
                return reply_count;
            }

            public void setReply_count(int reply_count) {
                this.reply_count = reply_count;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public long getDongtai_id() {
                return dongtai_id;
            }

            public void setDongtai_id(long dongtai_id) {
                this.dongtai_id = dongtai_id;
            }

            public int getUser_digg() {
                return user_digg;
            }

            public void setUser_digg(int user_digg) {
                this.user_digg = user_digg;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public static class ReplyDataBean {
                private List<?> reply_list;

                public List<?> getReply_list() {
                    return reply_list;
                }

                public void setReply_list(List<?> reply_list) {
                    this.reply_list = reply_list;
                }
            }

            public static class UserBean {
                /**
                 * avatar_url : https://p1.pstatp.com/thumb/3795/3044413937
                 * user_id : 3092133937
                 * name : 手机用户3092133937
                 */

                private String avatar_url;
                private long user_id;
                private String name;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
