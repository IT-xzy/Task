<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/6
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<json:object>
    <json:array name="国家" var="1" items="guojai">
        <json:property name="zhongguo" value="中国"/>
            <json:array name="省" var="2" items="province">
                <json:property name="guangdong" value="广东"/>
                    <json:array name="市" var="3" items="city">
                        <json:property name="shenzhen" value="深圳"/>
                        <json:property name="guangzhou" value="广州"/>
                    </json:array>
                <json:property name="sichuan" value="四川"/>
                <json:array name="市" var="4" items="city">
                    <json:property name="chengdu" value="成都"/>
                    <json:property name="luzhou" value="泸州"/>
                </json:array>
            </json:array>
        <json:property name="meiguo" value="美国"/>
        <json:property name="hanguo" value="韩国"/>
    </json:array>
</json:object>