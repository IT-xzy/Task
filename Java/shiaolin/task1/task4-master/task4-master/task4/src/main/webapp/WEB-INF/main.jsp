<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-01">
    <div class="feature">
        <div class="feature-bg feature-bg-01"></div>
        <div class="feature-title">高效</div>
        <div class="feature-content">将五到七年的成长时间，缩短到一年到三年</div>
    </div>
    <div class="feature">
        <div class="feature-bg feature-bg-02"></div>
        <div class="feature-title">规范</div>
        <div class="feature-content">标准的实践教程，不会走弯路</div>
    </div>
    <div class="feature">
        <div class="feature-bg feature-bg-03"></div>
        <div class="feature-title">人脉</div>
        <div class="feature-content">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路</div>
    </div>
    <div class="count">
        <div>12400
            <p>累计在线学习人数</p>
        </div>
        <div>12400
            <p>学员已找到满意工作</p>
        </div>
    </div>
</div>
<div class="row-02">
    <div class="row-02-title">如何学习</div>
    <div class="process1-4">
        <div class="process">
            <div class="circle">1</div>
            <p>匹配你现在的个人情况寻找合适自己的岗位</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">2</div>
            <p>了解职业前景薪资待遇竞争压力等</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">3</div>
            <p>掌握行内顶级技能</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">4</div>
            <p>查看职业目标任务</p>
            <div class="arrow-green circle-4"></div>
        </div>
    </div>
    <div class="process5-8">
        <div class="process">
            <div class="circle">5</div>
            <p>参考学习资源，掌握技能点，逐个完成任务</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">6</div>
            <p>加入班级，和小伙伴们互帮互助，一块学习</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">7</div>
            <p>选择导师，一路引导，加速自己成长</p>
            <div class="arrow-green"></div>
        </div>
        <div class="process">
            <div class="circle">8</div>
            <p>完成职业技能，升级业界大牛</p>
        </div>
    </div>
</div>
<div class="row-03">
    <div class="row-03-title">优秀学员展示</div>
    <div class="intro">
        <c:forEach items="${studentList}" var="info">
        <div class="col">
            <div class="intro-detail">
                <div class="avatar ava-02"></div>
                <b>${info.type}:${info.name}</b>
                <p>${info.introduction}</p>
            </div>
        </div>
        </c:forEach>
    </div>
    <div class="row-03-dot">
        <div>●</div>
        <div>●</div>
        <div>●</div>
        <div>●</div>
    </div>
</div>
<div class="row-04">
    <div class="row-04-title">战略合作企业</div>
    <div class="row-04-detail">
        <div class="cooperate-bg01">
            <div class="cooperate alibaba"></div>
            <div class="cooperate jinshanyun"></div>
            <div class="cooperate huanxin"></div>
            <div class="cooperate ronglian"></div>
            <div class="cooperate qiniu"></div>
            <div class="cooperate-bg02"></div>
        </div>
    </div>
</div>
