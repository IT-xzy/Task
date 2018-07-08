package hzw.util;

    public class Page {
        /**
         * Page类用于存放分页信息：
         *  start: 开始位置
         *  count: 每页的个数
         *  last: 最后一页的位置
         */
        int start = 0;
        int count = 5;
        int last = 0;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getLast() {
            return last;
        }

        public void setLast(int last) {
            this.last = last;
        }

        //caculateLast()方法: 通过总数total和每页的个数计算出最后一页的位置
        public void caculateLast(int total){
            // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
            if (total % count == 0)
                last = total - count;
                // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
            else
                last = total - total%count;
        }
    }


