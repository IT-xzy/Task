package com.restful.service;

import com.restful.model.User;

import java.util.Date;
import java.util.Random;

public class RandomUser {

    private StringBuilder nameBuilder = new StringBuilder();

    public User getRandomUser(){

        User user = new User();
        Random random = new Random();

        user.setName(getNameBuilder().toString());
        user.setPwd("password");
        user.setQq(random.nextInt(9999));
        user.setEmail(random.nextInt(9999) + "@user.com");
        user.setAddress(random.nextInt(99) + "号" + random.nextInt(999) + "间");
        user.setTell(random.nextInt(9999999));
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        return user;
    }

    protected StringBuilder getNameBuilder(){
        String[] strN = {
                "赵","钱","孙","李","周","吴","郑","王","诸葛","公孙",
                "冯","陈","褚","卫","蒋","沈","韩","杨","欧阳","乌良",
                "朱","秦","尤","许","何","吕","施","张","夏侯","东郭",
                "孔","曹","严","华","金","魏","陶","姜","乌苏","令狐",
                "戚","谢","邹","喻","柏","水","窦","章","司马","赫连",
                "云","苏","潘","葛","奚","范","彭","郎","拓跋","乐正",
                "廉颇","颇呵","欧冠","谷歌","皇","西","卡卡","吃","过","分",
                "鲁","韦","昌","马","苗","凤","花","方"};

        String[] strM = {
                "辰彬","运皓","骞腾","晨轩","侠宇","振震","骞晨","运骏","澄运","轩龙","逸辰","嘉","强",
                "盛凡","晨骏","柏成","凯骞","文邦","骞逸","梓然","鸿仕","树","翰","梁","允轩","炳家",
                "振家","辞","晨骞","良骏","骏晨","嘉中","畅胤","德稷","星运","潍","运帆","泽","辰",
                "铭","福","辞桀","材泽","华","华文","振良","祯逸","驰初","凯星","谷轩","辰嘉","震",
                "振坤","康骞","嘉","振","骏","爵斌","然允","嘉驰","勇骞","文骏","轩","骞梓","嘉俊",
                "运海","峰振","骏","良","家梓","加晨","权祜","阳","星轩","鸿锐","沛骞","畅","仕延",
                "暄","震家","郁辰","辰树","运奇","辰帝","杰运","成涛","博胤","信","初尧","良林",
                "高晨","命","北家","松木","醒","牙","利","峰峰","梁木","好好","球球","门伏","神漾",
                "嘉浩","哲权","腾骞","锋福","裕裕","天勇","鹤","运然","钊浩","球","门","漾",
                "暄","震家","郁辰","辰树","运奇","辰帝","杰运","成涛","博胤","信","初尧","良林",
                "高晨","命","北家","松木","醒","牙","利","峰峰","梁木","好好","球球","门伏","神漾",
                "东","西","南","北",
                "魄","英","鸥鸟","瀚海","荷","枫枫","男","东","西政","欧派","佛山","让","关",
                "高","路","南","宿也","吉利","烈焰","冰山","恴熙","木","不还","影","伏","凼"};

        nameBuilder.delete(0,999);
        nameBuilder.append(strN[(int)(Math.random()* strN.length)]);
        nameBuilder.append(strM[(int)(Math.random()* strN.length)]);

        return nameBuilder;
    }

}
