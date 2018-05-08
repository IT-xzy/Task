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
                                <div class="ios">${list[0].voca_name}</div>
                                ${list[0].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[0].voca_name}</h4><p class="table-p">${list[0].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[0].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                    </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[0].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[0]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[1].voca_name}</div>
                                ${list[1].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[1].voca_name}</h4><p class="table-p">${list[1].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[1].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[1].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[1]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[2].voca_name}</div>
                                ${list[2].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[2].voca_name}</h4><p class="table-p">${list[2].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[2].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[2].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[2]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
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
                                <div class="ios">${list[3].voca_name}</div>
                                ${list[3].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[3].voca_name}</h4><p class="table-p">${list[3].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[3].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[3].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[3]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>

                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[4].voca_name}</div>
                                ${list[4].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[4].voca_name}</h4><p class="table-p">${list[4].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[4].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[4].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[4]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[5].voca_name}</div>
                                ${list[5].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[5].voca_name}</h4><p class="table-p">${list[5].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[5].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[5].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[5]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>

                </div>
            </div>
        </div>
        <div class="row size">
            <div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[6].voca_name}</div>
                                ${list[6].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[6].voca_name}</h4><p class="table-p">${list[6].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[6].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[6].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[6]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                        </table>
                    </div>

                </div>
                <div class="col-md-4 col-sm-6 col-lg-4 div1">
                    <div class="table-size">
                        <table border="1">
                            <div class="divhover">
                                <div class="ios">${list[7].voca_name}</div>
                                ${list[7].description}</div>
                            <tr>
                                <td colspan="2">
                                    <div class="table-head">
                                        <div class="web-img"></div>
                                        <div><h4>${list[7].voca_name}</h4><p class="table-p">${list[7].description}</p></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                    <c:forEach begin="1" end="${list[7].threshold}">
                                        <div class="star"></div>
                                    </c:forEach>
                                </div></td>
                                <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                            </tr>
                            <tr>
                                <td>成长周期<red>1-3年</red></td>
                                <td>稀缺程度 <red>${list[7].demand}</red>家公司需要</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td>0-1年<div class="pay">5k-10k/月</div></td>
                            </tr>
                            <tr>
                                <td>1-3年<div class="pay">10k-20k/月</div></td>
                            </tr>
                            <tr>
                                <td>4年<div class="pay">20k-25k/月</div></td>
                            </tr>
                            <tr><td colspan="2">有<red>${integerList[7]}</red>正在学</td></tr>
                            <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
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
                            <div class="ios">${list[8].voca_name}</div>
                            ${list[8].description}</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${list[8].voca_name}</h4><p class="table-p">${list[8].description}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <c:forEach begin="1" end="${list[8].threshold}">
                                    <div class="star"></div>
                                </c:forEach>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>1-3年</red></td>
                            <td>稀缺程度 <red>${list[8].demand}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">5k-10k/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">10k-20k/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">20k-25k/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${integerList[8]}</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                    </table>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${list[9].voca_name}</div>
                            ${list[9].description}</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${list[9].voca_name}</h4><p class="table-p">${list[9].description}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <c:forEach begin="1" end="${list[9].threshold}">
                                    <div class="star"></div>
                                </c:forEach>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>1-3年</red></td>
                            <td>稀缺程度 <red>${list[9].demand}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">5k-10k/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">10k-20k/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">20k-25k/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${integerList[9]}</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                    </table>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${list[10].voca_name}</div>
                            ${list[10].description}</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${list[10].voca_name}</h4><p class="table-p">${list[10].description}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <c:forEach begin="1" end="${list[10].threshold}">
                                    <div class="star"></div>
                                </c:forEach>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>1-3年</red></td>
                            <td>稀缺程度 <red>${list[10].demand}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">5k-10k/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">10k-20k/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">20k-25k/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${integerList[10]}</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                    </table>
                </div>

            </div>
        </div>
        <!--运维-->
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <a name="site-development"></a> <div class="qianduan-top"><strong>整站开发</strong></div>
            </div>
        </div>
        <!--运维1-->
        <div class="row size">
            <div class="col-md-4 col-sm-6 col-lg-4">
                <div class="table-size">
                    <table border="1">
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${list[11].voca_name}</h4><p class="table-p">${list[11].description}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <c:forEach begin="1" end="${list[11].threshold}">
                                    <div class="star"></div>
                                </c:forEach>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div><div class="star"></div><div class="star"></div></div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>1-3年</red></td>
                            <td>稀缺程度 <red>${list[11].demand}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">5k-10k/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">10k-20k/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">20k-25k/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${integerList[11]}</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

