<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="body">
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
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[0].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[0].info}</p>
                                                </div>
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
                                            <red>${list[0].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[0].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[0].experience1}
                                            <div class="pay">${list[0].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience2}
                                            <div class="pay">${list[0].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience3}
                                            <div class="pay">${list[0].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[0].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[0].reminder}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 col-lg-4 div1">
                            <div class="table-size">
                                <table border="1">
                                    <div class="divhover">
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[1].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[1].info}</p>
                                                </div>
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
                                            <red>${list[1].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[1].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[1].experience1}
                                            <div class="pay">${list[1].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[1].experience2}
                                            <div class="pay">${list[1].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[1].experience3}
                                            <div class="pay">${list[1].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[1].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[1].reminder}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 col-lg-4 div1">
                            <div class="table-size">
                                <table border="1">
                                    <div class="divhover">
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[2].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[2].info}</p>
                                                </div>
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
                                            <red>${list[2].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[2].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[2].experience1}
                                            <div class="pay">${list[2].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[2].experience2}
                                            <div class="pay">${list[2].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[2].experience3}
                                            <div class="pay">${list[2].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[2].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[2].reminder}</td>
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
                                        <div class="ios">java工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[4].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[4].info}</p>
                                                </div>
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
                                            <red>${list[4].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[4].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[4].experience1}
                                            <div class="pay">${list[4].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[4].experience2}
                                            <div class="pay">${list[4].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[4].experience3}
                                            <div class="pay">${list[4].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[4].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[4].reminder}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 col-lg-4 div1">
                            <div class="table-size">
                                <table border="1">
                                    <div class="divhover">
                                        <div class="ios">python</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[5].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[5].info}</p>
                                                </div>
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
                                            <red>${list[5].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[5].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[5].experience1}
                                            <div class="pay">${list[5].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[5].experience2}
                                            <div class="pay">${list[5].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[5].experience3}
                                            <div class="pay">${list[5].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[5].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[5].reminder}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 col-lg-4 div1">
                            <div class="table-size">
                                <table border="1">
                                    <div class="divhover">
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[0].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[0].info}</p>
                                                </div>
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
                                            <red>${list[0].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[0].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[0].experience1}
                                            <div class="pay">${list[0].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience2}
                                            <div class="pay">${list[0].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience3}
                                            <div class="pay">${list[0].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[0].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[0].reminder}</td>
                                    </tr>
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
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[0].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[0].info}</p>
                                                </div>
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
                                            <red>${list[0].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[0].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[0].experience1}
                                            <div class="pay">${list[0].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience2}
                                            <div class="pay">${list[0].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience3}
                                            <div class="pay">${list[0].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[0].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[0].reminder}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 col-lg-4 div1">
                            <div class="table-size">
                                <table border="1">
                                    <div class="divhover">
                                        <div class="ios">ios工程师</div>
                                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                    </div>
                                    <tr>
                                        <td colspan="2">
                                            <div class="table-head">
                                                <div class="web-img"></div>
                                                <div><h4>${list[0].occupation}</h4>
                                                    <p class="table-p">
                                                            ${list[0].info}</p>
                                                </div>
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
                                            <red>${list[0].growth_cycle}</red>
                                        </td>
                                        <td>稀缺程度
                                            <red>${list[0].rareness}</red>
                                            家公司需要
                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td>${list[0].experience1}
                                            <div class="pay">${list[0].salary1}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience2}
                                            <div class="pay">${list[0].salary2}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>${list[0].experience3}
                                            <div class="pay">${list[0].salary3}</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">有
                                            <red>${list[0].students}人</red>
                                            正在学
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">${list[0].reminder}</td>
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
                                    <div class="ios">op工程师</div>
                                    ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                </div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[6].occupation}</h4>
                                                <p class="table-p">
                                                        ${list[6].info}</p>
                                            </div>
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
                                        <red>${list[6].growth_cycle}</red>
                                    </td>
                                    <td>稀缺程度
                                        <red>${list[6].rareness}</red>
                                        家公司需要
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>${list[6].experience1}
                                        <div class="pay">${list[6].salary1}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[6].experience2}
                                        <div class="pay">${list[6].salary2}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[6].experience3}
                                        <div class="pay">${list[6].salary3}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">有
                                        <red>${list[6].students}人</red>
                                        正在学
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">${list[6].reminder}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">ios工程师</div>
                                    ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                </div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[0].occupation}</h4>
                                                <p class="table-p">
                                                        ${list[0].info}</p>
                                            </div>
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
                                        <red>${list[0].growth_cycle}</red>
                                    </td>
                                    <td>稀缺程度
                                        <red>${list[0].rareness}</red>
                                        家公司需要
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>${list[0].experience1}
                                        <div class="pay">${list[0].salary1}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience2}
                                        <div class="pay">${list[0].salary2}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience3}
                                        <div class="pay">${list[0].salary3}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">有
                                        <red>${list[0].students}人</red>
                                        正在学
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">${list[0].reminder}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">ios工程师</div>
                                    ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                </div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[0].occupation}</h4>
                                                <p class="table-p">
                                                        ${list[0].info}</p>
                                            </div>
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
                                        <red>${list[0].growth_cycle}</red>
                                    </td>
                                    <td>稀缺程度
                                        <red>${list[0].rareness}</red>
                                        家公司需要
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>${list[0].experience1}
                                        <div class="pay">${list[0].salary1}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience2}
                                        <div class="pay">${list[0].salary2}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience3}
                                        <div class="pay">${list[0].salary3}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">有
                                        <red>${list[0].students}人</red>
                                        正在学
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">${list[0].reminder}</td>
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
                <!--运维1-->
                <div class="row size">
                    <div class="col-md-4 col-sm-6 col-lg-4 div1">
                        <div class="table-size">
                            <table border="1">
                                <div class="divhover">
                                    <div class="ios">ios工程师</div>
                                    ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。
                                </div>
                                <tr>
                                    <td colspan="2">
                                        <div class="table-head">
                                            <div class="web-img"></div>
                                            <div><h4>${list[0].occupation}</h4>
                                                <p class="table-p">
                                                        ${list[0].info}</p>
                                            </div>
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
                                        <red>${list[0].growth_cycle}</red>
                                    </td>
                                    <td>稀缺程度
                                        <red>${list[0].rareness}</red>
                                        家公司需要
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td rowspan="3">薪资待遇</td>
                                    <td>${list[0].experience1}
                                        <div class="pay">${list[0].salary1}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience2}
                                        <div class="pay">${list[0].salary2}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>${list[0].experience3}
                                        <div class="pay">${list[0].salary3}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">有
                                        <red>${list[0].students}人</red>
                                        正在学
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">${list[0].reminder}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>