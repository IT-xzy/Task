package com.task5.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.random;

public class RandomUntil {
    /** 姓 */
    public static String[] firsname = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕",
            "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢",
            "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范",
            "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任",
            "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于",
            "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟",
            "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛",
            "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋",
            "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮",
            "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童",
            "颜", "郭", "梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏",
            "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管",
            "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣",
            "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉",
            "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊",
            "於", "惠", "甄", "麹", "家", "封", "芮", "羿", "储", "靳", "汲", "邴",
            "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗",
            "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲",
            "伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖", "武",
            "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎",
            "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸",
            "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能",
            "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申",
            "扶", "堵", "冉", "宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛",
            "寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别",
            "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾",
            "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居",
            "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",
            "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩",
            "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简",
            "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关",
            "蒯", "相", "查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益",
            "桓", "公", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连",
            "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于", "太叔",
            "申屠", "公孙", "仲孙", "轩辕", "令狐", "锺离", "宇文", "长孙", "慕容", "鲜于",
            "闾丘", "司徒", "司空", "丌官", "司寇", "仉", "督", "子车", "颛孙", "端木", "巫马",
            "公西", "漆雕", "乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父", "谷梁", "晋", "楚",
            "阎", "法", "汝", "鄢", "涂", "钦", "段干", "百里", "东郭", "南门", "呼延",
            "归", "海", "羊舌", "微生", "岳", "帅", "缑", "亢", "况", "后", "有", "琴",
            "梁丘", "左丘", "东门", "西门", "商", "牟", "佘", "佴", "伯", "赏", "南宫",
            "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟" };

    /** 女生ming */
    private static String girls="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞" +
            "香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊" +
            "薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    /** 男生名 */
    private static String boys="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清" +
            "飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超" +
            "浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    /**
     * 根据性别生成2-5位的随机名字
     * @param sex 性别  0：女生，1：男生
     * @return
     */
    public static String getRandomChinese(String sex){
        //随机获取姓
        int a = (int) Math.abs(firsname.length * Math.random());
        //产生1-3的随机数
        int random = new Random().nextInt(3)+1 ;
        int i = 0 ;
        String lastName = "" ;//名
        if("0".equals(sex.trim())){
            int girlLen = girls.length() ;
            for(;i<random;i++){
                int k = (int) Math.abs(girlLen * Math.random());
                lastName += girls.substring(k,k+1) ;
            }
        }else{
            int boyLen = boys.length() ;
            for(;i<random;i++){
                int k = (int) Math.abs(boyLen * Math.random());
                lastName += boys.substring(k,k+1) ;
            }
        }

        return firsname[a]+lastName ;
    }

    /**
     * 生成指定长度的数字随机数
     * @param length 长度
     * @return String
     */
    public static  String getRandNumberCode (int length)    {
        Random random = new Random();
        String result="";
        for(int i=0;i<length;i++){
            result+=random.nextInt(9);
        }
        return result;
    }

    /**
     * 生成指定长度的数字随机数,不能以0开头
     * @param length 长度
     * @return String
     */
    public static  String getRandNumber (int length)    {
        //第一位随机数
        String temp = "123456789";
        int len = temp.length();
        int p;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        p = r.nextInt(len);
        sb.append(temp.substring(p, p + 1));

        //除第一位以外其他随机数
        for(int i=0;i<length-1;i++){
            sb.append(r.nextInt(9));
        }
        return sb.toString();
    }

    /**
     * 生成相应长度的数字字母组合的随机数
     * @param size 长度
     * @return String
     */
    public static String getRandStrCode(int size) {
        String temp = "ABCDEFGHJKLMNPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        int length = temp.length();
        int p;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            p = r.nextInt(length);
            sb.append(temp.substring(p, p + 1));
        }
        return sb.toString();
    }

    /**
     * 生成指定长度的字母随机数
     * @param size 长度
     * @return 字符串
     */
    public static String getRandEnglishCode(int size) {
        String temp = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int length = temp.length();
        int p;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            p = r.nextInt(length);
            sb.append(temp.substring(p, p + 1));
        }
        return sb.toString();
    }
    public static String getProfessional(){
        String[] proNameArrary = {"css", "js", "android", "ios", "java", "op", "pm", "ui", "qa" };
        int proNames = (int)(9*random());
        return proNameArrary[proNames];
    }
    public static String getStartTime() {
                 // 先确定2016.1.1和2017.12.31对应的毫秒数，在此范围内生成long随机数，然后根据该随机数生成java.sql.Date，再toString。
               Calendar calendar = Calendar.getInstance();
               calendar.clear();
                calendar.set(2016, 0, 1);
                 long minMillis = calendar.getTimeInMillis();
                 calendar.set(2018, 0, 1);
                long maxMillis = calendar.getTimeInMillis();
                long millis = (long) ((maxMillis - minMillis) * random()) + minMillis;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date(millis));
                 return date;
             }

    public static String getUniversity() {
        String[] schoolArray = { "北京大学", "清华大学", "武汉大学", "复旦大学", "浙江大学", "上海交通大学", "南京大学", "中国人民大学", "解放军国防科学技术大学",
               "吉林大学" };
        int schoolPos = (int) (10 * random());
        return schoolArray[schoolPos];
    }
    //生成随机的线上学号
    public static  String getOnlineId (int length)    {
        Random random = new Random();
        String result="";
        for(int i=0;i<length;i++){
            result+=random.nextInt(4);
        }
        return result;
    }

    public static String getDailyUrl() {
        return "http://www.jnshu.com/daily/" + getOnlineId(4);
    }

    public static String getOath(){
        return "好好学习哈！";
    }
    public static String getCity(){
        String[] cityArray = { "郑州", "北京", "武汉", "成都", "西安", "上海", "深圳", "新疆","萌新分院"};
        int citys = (int) (9 * random());
        return cityArray[citys];
    }
}
