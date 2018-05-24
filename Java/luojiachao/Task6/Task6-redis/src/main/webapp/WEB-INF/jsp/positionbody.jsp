<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/5/1
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!--main-->
    <div class="row">
        <div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
            <!--首页职业-->
            <div class="row">
                <div class="col-md-12 col-lg-12 job-row3">
                    首页＞<a href="#" class="job-top">职业</a>
                </div>
            </div>
            <!--主要方向-->
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <div class="job-select">
                        <div class="side">方向：</div>
                        <a href="#" class="job-type">全部</a>
                        <a href="#web" class="job-type">前端开发</a>
                        <a href="#java" class="job-type">后端开发</a>
                        <a href="#mobile" class="job-type">移动开发</a>
                        <a href="#site-development" class="job-type">整站开发</a>
                        <a href="#operation" class="job-type">运营维护</a>
                    </div>
                </div>
            </div>
            <!--前端-->
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <a name="web"></a><div class="qianduan-top"><strong>前端开发方向</strong></div>
                </div>
            </div>
            <!--前端1-->
            <div class="row size">
                <div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[3].classes}</div>
                                    ${list[3].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[3].classes}</h4><p class="table-p">${list[3].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[3].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[3].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[3].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[3].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[3].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[3].prompt}</td></tr>
                            </table>
                        </div>

                    </div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[4].classes}</div>
                                    ${list[4].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[4].classes}</h4><p class="table-p">${list[4].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[4].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[4].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[4].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[4].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[4].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[4].prompt}</td></tr>
                            </table>
                        </div>

                    </div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[0].classes}</div>
                                    ${list[0].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[0].classes}</h4><p class="table-p">${list[0].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[0].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[0].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[0].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[0].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[0].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[0].prompt}</td></tr>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
            <!--后端-->
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <a name="java"></a> <div class="qianduan-top"><strong>后端开发方向</strong></div>
                </div>
            </div>
            <!--后端1-->
            <div class="row size">
                <div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[1].classes}</div>
                                    ${list[1].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[1].classes}</h4><p class="table-p">${list[1].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[1].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[1].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[1].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[1].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[1].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[1].prompt}</td></tr>
                            </table>
                        </div>

                    </div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[2].classes}</div>
                                    ${list[2].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[2].classes}</h4><p class="table-p">${list[2].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[2].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[2].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[2].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[2].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[2].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[2].prompt}</td></tr>
                            </table>
                        </div>

                    </div>

                </div>
            </div>

            <!--运维-->
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <a name="mobile"></a><div class="qianduan-top"><strong>移动开发</strong></div>
                </div>
            </div>
            <!--运维1-->
            <div class="row size">
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[6].classes}工程师</div>
                                ${list[6].introduce}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[6].classes}工程师</h4><p class="table-p">${list[6].introduce}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>${list[6].grow}年</red></td>
                                <td>稀缺程度 <red>${list[6].need}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">${list[6].salary1year}/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">${list[6].salary3year}/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">${list[6].salary4year}/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                            <tr><td colspan="2">提示：${list[6].prompt}</td></tr>
                        </table>
                    </div>

                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[5].classes}工程师</div>
                                ${list[5].introduce}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[5].classes}工程师</h4><p class="table-p">${list[5].introduce}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>${list[5].grow}年</red></td>
                                <td>稀缺程度 <red>${list[5].need}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">${list[5].salary1year}/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">${list[5].salary3year}/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">${list[5].salary4year}/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                            <tr><td colspan="2">提示：${list[5].prompt}</td></tr>
                        </table>
                    </div>
                </div>
            </div>
            <!--用户体验-->
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <a name="site-development"></a> <div class="qianduan-top"><strong>用户体验</strong></div>
                </div>
            </div>
            <!--用户体验-->
            <div class="row size">
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[8].classes}</div>
                                ${list[8].introduce}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[8].classes}</h4><p class="table-p">${list[8].introduce}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>${list[8].grow}年</red></td>
                                <td>稀缺程度 <red>${list[8].need}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">${list[8].salary1year}/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">${list[8].salary3year}/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">${list[8].salary4year}/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                            <tr><td colspan="2">提示：${list[8].prompt}</td></tr>
                        </table>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[9].classes}</div>
                                ${list[9].introduce}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[9].classes}</h4><p class="table-p">${list[9].introduce}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>${list[9].grow}年</red></td>
                                <td>稀缺程度 <red>${list[9].need}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">${list[9].salary1year}/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">${list[9].salary3year}/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">${list[9].salary4year}/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                            <tr><td colspan="2">提示：${list[9].prompt}</td></tr>
                        </table>
                    </div>
                </div>
                <!--运维-->
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <a name="site-development"></a> <div class="qianduan-top"><strong>运维</strong></div>
                    </div>
                </div>
                <!--运维-->
                <div class="row size">
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">${list[7].classes}</div>
                                    ${list[7].introduce}</div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[7].classes}</h4><p class="table-p">${list[7].introduce}</p></div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div><div class="star"></div></div></td>
                                    <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                                </tr>
                                <tr>
                                    <td>成长周期<red>${list[7].grow}年</red></td>
                                    <td>稀缺程度 <red>${list[7].need}</red>家公司需要</td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>0-1年<div class="pay">${list[7].salary1year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>1-3年<div class="pay">${list[7].salary3year}/月</div></td>
                                </tr>
                                <tr>
                                    <td>4年<div class="pay">${list[7].salary4year}/月</div></td>
                                </tr>
                                <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                                <tr><td colspan="2">提示：${list[7].prompt}</td></tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
