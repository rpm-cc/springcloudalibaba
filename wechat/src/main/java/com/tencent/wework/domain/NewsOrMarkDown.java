package com.tencent.wework.domain;

import java.util.List;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class NewsOrMarkDown {
    /**
     * 图文消息数组，每个item结构包含title、description、url、picurl等结构
     */
    private List<Item> item;

    private String content;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "item=" + item +
                ", content='" + content + '\'' +
                '}';
    }

    class Item {
        /**
         * 图文消息标题。String类型
         */
        private String title;
        /**
         * 图文消息描述。String类型
         */
        private String description;
        /**
         * 图文消息点击跳转地址。String类型
         */
        private String url;
        /**
         * 图文消息配图的url。String类型
         */
        private String picurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", url='" + url + '\'' +
                    ", picurl='" + picurl + '\'' +
                    '}';
        }
    }

}
