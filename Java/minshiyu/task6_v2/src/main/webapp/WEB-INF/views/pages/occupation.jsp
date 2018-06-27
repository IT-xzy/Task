<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<main>
    <div class="col-md-12 col-sm-12 col-lg-12 job-row3">
        首页＞<a class="company" href="#">职业</a>
    </div>
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
    <!--前端-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="web"></a>
            <div class="qianduan-top"><strong>前端开发方向</strong></div>
        </div>
    </div>
    <!--前端1-->
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[0].name}</div>
                            ${occupations[0].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[0].name}</h4>
                                        <p class="table-p">
                                            ${occupations[0].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[0].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[0].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[0].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[0].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[0].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[0].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[0].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[1].name}</div>
                            ${occupations[1].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[1].name}</h4>
                                        <p class="table-p">
                                            ${occupations[1].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[1].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[1].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[1].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[1].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[1].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[1].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[1].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[2].name}</div>
                            ${occupations[2].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[2].name}</h4>
                                        <p class="table-p">
                                            ${occupations[2].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[2].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[2].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[2].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[2].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[2].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[2].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[2].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--后端-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="java"></a>
            <div class="qianduan-top"><strong>后端开发方向</strong></div>
        </div>
    </div>
    <!--后端1-->

    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[3].name}</div>
                            ${occupations[3].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[3].name}</h4>
                                        <p class="table-p">
                                            ${occupations[3].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[3].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[3].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[3].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[3].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[3].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[3].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[3].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[4].name}</div>
                            ${occupations[4].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[4].name}</h4>
                                        <p class="table-p">
                                            ${occupations[4].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[4].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[4].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[4].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[4].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[4].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[4].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[4].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--运维-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="mobile"></a>
            <div class="qianduan-top"><strong>移动开发</strong></div>
        </div>
    </div>
    <!--运维1-->
    <div class="row size">
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">${occupations[5].name}</div>
                        ${occupations[5].descriptionDetailed}
                    </div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>${occupations[5].name}</h4>
                                    <p class="table-p">
                                        ${occupations[5].descriptionGeneral}</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;">
                            <div class="danteng">
                                <div class="star-left">门槛</div>
                                <div class="star"></div>
                                <div class="star"></div>
                                <div class="star"></div>
                            </div>
                        </td>
                        <td>
                            <div class="danteng">
                                <div>难易程度</div>
                                <div class="star"></div>
                                <div class="star"></div>
                                <div class="star"></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>成长周期
                            <red>${occupations[5].growthCycle}年</red>
                        </td>
                        <td>稀缺程度
                            <red>${occupations[5].scarcity}</red>
                            家公司需要
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年
                            <div class="pay">${occupations[5].salaryFreshman}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td>1-3年
                            <div class="pay">${occupations[5].salaryJunior}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td>4年
                            <div class="pay">${occupations[5].salarySenior}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">有
                            <red>${occupations[5].isLearning}人</red>
                            正在学
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">${occupations[5].tips}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">${occupations[6].name}</div>
                        ${occupations[6].descriptionDetailed}
                    </div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>${occupations[6].name}</h4>
                                    <p class="table-p">
                                        ${occupations[6].descriptionGeneral}</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;">
                            <div class="danteng">
                                <div class="star-left">门槛</div>
                                <div class="star"></div>
                                <div class="star"></div>
                                <div class="star"></div>
                            </div>
                        </td>
                        <td>
                            <div class="danteng">
                                <div>难易程度</div>
                                <div class="star"></div>
                                <div class="star"></div>
                                <div class="star"></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>成长周期
                            <red>${occupations[6].growthCycle}年</red>
                        </td>
                        <td>稀缺程度
                            <red>${occupations[6].scarcity}</red>
                            家公司需要
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年
                            <div class="pay">${occupations[6].salaryFreshman}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td>1-3年
                            <div class="pay">${occupations[6].salaryJunior}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td>4年
                            <div class="pay">${occupations[6].salarySenior}/月</div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">有
                            <red>${occupations[6].isLearning}人</red>
                            正在学
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">${occupations[6].tips}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!--运维-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="site-development"></a>
            <div class="qianduan-top"><strong>整站开发</strong></div>
        </div>
    </div>
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[7].name}</div>
                            ${occupations[7].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[7].name}</h4>
                                        <p class="table-p">
                                            ${occupations[7].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[7].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[7].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[7].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[7].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[7].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[7].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[7].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[8].name}</div>
                            ${occupations[8].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[8].name}</h4>
                                        <p class="table-p">
                                            ${occupations[8].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[8].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[8].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[8].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[8].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[8].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[8].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[8].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[9].name}</div>
                            ${occupations[9].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[9].name}</h4>
                                        <p class="table-p">
                                            ${occupations[9].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[9].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[9].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[9].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[9].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[9].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[9].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[9].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--运维1-->
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[10].name}</div>
                            ${occupations[10].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[10].name}</h4>
                                        <p class="table-p">
                                            ${occupations[10].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[10].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[10].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[10].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[10].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[10].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[10].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[10].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${occupations[11].name}</div>
                            ${occupations[11].descriptionDetailed}
                        </div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${occupations[11].name}</h4>
                                        <p class="table-p">
                                            ${occupations[11].descriptionGeneral}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;">
                                <div class="danteng">
                                    <div class="star-left">门槛</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                            <td>
                                <div class="danteng">
                                    <div>难易程度</div>
                                    <div class="star"></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期
                                <red>${occupations[11].growthCycle}年</red>
                            </td>
                            <td>稀缺程度
                                <red>${occupations[11].scarcity}</red>
                                家公司需要
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年
                                <div class="pay">${occupations[11].salaryFreshman}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>1-3年
                                <div class="pay">${occupations[11].salaryJunior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td>4年
                                <div class="pay">${occupations[11].salarySenior}/月</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有
                                <red>${occupations[11].isLearning}人</red>
                                正在学
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">${occupations[11].tips}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>