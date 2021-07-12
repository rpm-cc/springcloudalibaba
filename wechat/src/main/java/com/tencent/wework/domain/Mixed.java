package com.tencent.wework.domain;

import java.util.List;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 */
public class Mixed {

    List<Item> item;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Mixed{" +
                "item=" + item +
                '}';
    }

    class Item {
        /**
         * 消息类型
         */
        private String type;
        /**
         * 消息内容
         */
        private String content;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "type='" + type + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
