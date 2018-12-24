package com.suger.util;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 随机数据工具类
 *
 * @author suger
 * @date 2018-09-18
 */
public class DataUtils {

    /**
     * 生成随机姓名
     *
     * @return 姓名
     */
    public static String getName() {
        Random random = new Random();
        String[] names = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(names.length - 1);
        //获得一个随机的姓氏
        String name = names[index];
        //可以根据这个数设置产生的男女比例
        int i = random.nextInt(3);
        if (i == 2) {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = name + girl.substring(j, j + 2);
            } else {
                name = name + girl.substring(j, j + 1);
            }
        } else {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = name + boy.substring(j, j + 2);
            } else {
                name = name + boy.substring(j, j + 1);
            }
        }
        return name;
    }

    public static String getProfession() {

        String profession = null;
        Random random = new Random();
        String[] strs = {"Java", "python","Android", "ios", "op", "js", "ui", "pm", "运营", "css"};
        int num = random.nextInt(strs.length);
        profession = strs[num];
        return profession;
    }
    public static String getSex() {

        String sex = null;
        Random random = new Random();
        String[] strs = {"男","女"};
        int num = random.nextInt(strs.length);
        sex = strs[num];
        return sex;
    }
    public static String getSalary() {

        String salary = null;
        Random random = new Random();
        String[] strs = {"5K","6K","7K","8K","9K","10K","11K","12K","13K","14K","15K","16K",};
        int num = random.nextInt(strs.length);
        salary = strs[num];
        return salary;
    }
    public static String getImg() {

        String img = null;
        Random random = new Random();
        String[] strs = {"9-task8.png","10-task8.png","11-task8.png","12-task8.png",};
        int num = random.nextInt(strs.length);
        img = strs[num];
        return img;
    }
    public static String getPosition() {

        String position = null;
        Random random = new Random();
        String[] strs = {"技术主管","小组负责人","技术支持","运维","后勤"};
        int num = random.nextInt(strs.length);
        position = strs[num];
        return position;
    }

    public static String getIntro() {

        String intro = null;
        Random random = new Random();
        String[] strs = {"日常码代码","不用写代码啦","想学安全管理"};
        int num = random.nextInt(strs.length);
        intro = strs[num];
        return intro;
    }
    public static  boolean getType() {
        Boolean type = null;
        Random random = new Random();
        Boolean[] strs={true,false};
        int num = random.nextInt(strs.length);
        type = strs[num];
        return type;
    }


    /**
     * @return 何处了解
     */
    public String getWay() {
        String way = null;
        Random random = new Random();
        String[] strs1 = {"知乎", "csdn", "百度贴吧", "博客园", "官网"};
        int num = random.nextInt(strs1.length);
        way = strs1[num];
        return way;
    }

    public static String getCollege() {
        String colllege = null;
        Random random = new Random();
        String[] strs2 = {"北京工业大学", "北京师范大学", "许昌学院", "东华学院", "杭州理工学院",};
        int num = random.nextInt(strs2.length);
        colllege = strs2[num];
        return colllege;
    }

    /**
     * @return 当前时间 60天以内的日期
     */
    public static String getDateTime() {
        String datetime = null;
        Random rd = new Random();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long h = 3600000 * rd.nextInt(24);
        long day = h * rd.nextInt(60);
        long ts = System.currentTimeMillis() + h + day;
        datetime = df.format(ts);
        return datetime;
    }

    public static Long getTime() {
        long datetime = System.currentTimeMillis();
        return datetime;
    }

    /**
     * 随机 n位全部为数字的字符串
     *
     * @param n
     * @return
     */
    public static String getNumber(int n) {
        String sources = "0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < n; j++) {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return flag.toString();
    }

    /**
     * @return 5位数（int类型）
     */
    public static int getIntNumber() {

        Random random = new Random();
        int num = random.nextInt(99999);
        if (num < 10000) {
            num += 10000;
        }
        return num;
    }

    public static String getLink() {
        String link = "http://www.jnshu.com/school/" + DataUtils.getNumber(5) + "/daily";
        return link;
    }

    public static String getWish() {
        String wish = "养活自己";
        return wish;
    }

}
