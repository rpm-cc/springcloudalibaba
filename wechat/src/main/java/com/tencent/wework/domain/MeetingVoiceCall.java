package com.tencent.wework.domain;

import java.util.List;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class MeetingVoiceCall {
    /**
     * 音频结束时间。uint32类型 单位秒
     */
    private long endtime;
    /**
     * sdkfileid。音频媒体下载的id。String类型
     */
    private String sdkfileid;
    /**
     * 文档分享对象，Object类型
     */

    private List<Demofiledata> demofiledata;

    /**
     * 屏幕共享对象，Object类型
     */
    private List<Sharescreendata> sharescreendata;

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public String getSdkfileid() {
        return sdkfileid;
    }

    public void setSdkfileid(String sdkfileid) {
        this.sdkfileid = sdkfileid;
    }

    public List<Demofiledata> getDemofiledata() {
        return demofiledata;
    }

    public void setDemofiledata(List<Demofiledata> demofiledata) {
        this.demofiledata = demofiledata;
    }

    public List<Sharescreendata> getSharescreendata() {
        return sharescreendata;
    }

    public void setSharescreendata(List<Sharescreendata> sharescreendata) {
        this.sharescreendata = sharescreendata;
    }

    @Override
    public String toString() {
        return "MeetingVoiceCall{" +
                "endtime=" + endtime +
                ", sdkfileid='" + sdkfileid + '\'' +
                ", demofiledata=" + demofiledata +
                ", sharescreendata=" + sharescreendata +
                '}';
    }

    class Demofiledata {
        /**
         * 文档共享名称。String类型
         */
        private String filename;
        /**
         * 文档共享操作用户的id。String类型
         */
        private String demooperator;
        /**
         * 文档共享开始时间。Uint32类型 单位秒
         */
        private long starttime;
        /**
         * 文档共享结束时间。Uint32类型
         */
        private long endtime;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getDemooperator() {
            return demooperator;
        }

        public void setDemooperator(String demooperator) {
            this.demooperator = demooperator;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }

        public long getEndtime() {
            return endtime;
        }

        public void setEndtime(long endtime) {
            this.endtime = endtime;
        }

        @Override
        public String toString() {
            return "Demofiledata{" +
                    "filename='" + filename + '\'' +
                    ", demooperator='" + demooperator + '\'' +
                    ", starttime=" + starttime +
                    ", endtime=" + endtime +
                    '}';
        }
    }


    class Sharescreendata {
        /**
         * 屏幕共享用户的id。String类型
         */
        private String share;
        /**
         * 屏幕共享开始时间。Uint32类型
         */
        private long starttime;
        /**
         * 屏幕共享结束时间。Uint32类型
         */
        private long endtime;

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }

        public long getEndtime() {
            return endtime;
        }

        public void setEndtime(long endtime) {
            this.endtime = endtime;
        }

        @Override
        public String toString() {
            return "Sharescreendata{" +
                    "share='" + share + '\'' +
                    ", starttime=" + starttime +
                    ", endtime=" + endtime +
                    '}';
        }
    }
}
