<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="js/job.css" />
<%--<main>--%>
<!--轮播图-->
    <div class="container">
		<div class="row">
			<div class="col-md-12">
				<p>首页 > <span class="color-green">职业</span></p>
			</div>
			<div class="nav-t">
				<div class="col-md-1 nav-l">
					方向:
				</div>
				<div class="col-md-1 nav-a">
					全部
				</div>
				<div class="col-md-1 nav-a">
					<a href="#t1">前端开发</a>
				</div>
				<div class="col-md-1 nav-a">
					<a href="#t2">后端开发</a>
				</div>
				<div class="col-md-1 nav-a">
					<a href="#t3">运营维护</a>
				</div>
				<div class="col-md-1 nav-a">
					<a href="#t4">移动开发</a>
				</div>
				<div class="col-md-1 nav-a">
					<a href="#t5">整站开发</a>
				</div>
			</div>
		</div>
    </div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<p><a name="t1"></a>前端开发方向</p>
			</div>
			<div class="col-md-4">
				<div class="hid-box">
					<table class="outtb">
						<tr>
							<th class="th-l">
								<img class="photo" src="${pageContext.request.contextPath}/img/职位/photo.png">
							</th>
							<th>
								<h4>web前端开发工程师</h4>
								<p class="tbp">web前端开发工程师，主要职责是利用（X）HTML/CSS/JAVAScript/flash等各种web技术进行产品的开发。</p>
							</th>
						</tr>
						<tr>
							<td><span class="size1">门槛</span><span class="glyphicon glyphicon-star five"></span>
							</td>
							<td><span class="size1">难易程度</span><span class="glyphicon glyphicon-star five"></span><span class="glyphicon glyphicon-star five"></span>
							</td>
						</tr>
						<tr>
							<td>
								<span class="size1">成长周期</span> &nbsp<span class="color-red">1-3</span>年
							</td>
							<td>
								<span class="size1">稀缺程度</span>  &nbsp<span class="color-red">345</span>家公司需要
							</td>
						</tr>
							<td colspan="2" class="outtd">
								<table class="intb">
									<tr>
										<td rowspan="3" class="bigtd">
												<span class="size1">薪资待遇</span>
										</td>
										<td class="longtd">
											<span>0-1年</span> <span>5k-10k每月</span>
										</td>
									</tr>
									<tr>
										<td class="longtd mintd">
										<span>1-3年</span> <span>10k-20k每月</span>
										</td>
									</tr>
									<tr>
										<td class="longtd">
										<span>3-5年</span> <span>20k-50k每月</span>
										</td>
									</tr>
								</table>
							</td>
						<tr>
							<td colspan="2">
								有<span class="color-red">268人</span>正在学
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<span class="size1">提示：在你学习之前你应该掌握了xxxx,xxxx,xx等语言基础</span>
							</td>
						</tr>
					</table>
					<div class="hid">
						<p class="hid-t">ios工程师</p>
						<p class="hid-b">iOS是由苹果公司开发的移动操作系统。iOS与苹果的Mac OS X操作系统一样，属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</p>
					</div>
				</div>
			</div>
        </div>
    </div>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<p><a name="t1"></a>后端开发方向</p>
		</div>
		<div class="col-md-4">
			<div class="hid-box">
				<table class="outtb">
					<tr>
						<th class="th-l">
							<img class="photo" src="${pageContext.request.contextPath}/${eng.engineerImg}">
						</th>
						<th>
							<h4>${eng.engineerType}</h4>
							<p class="tbp">${eng.engineerIntro}</p>
						</th>
					</tr>
					<tr>
						<td><span class="size1">门槛:${eng.engineerSill}</span>
							<span class="glyphicon glyphicon-star five"/>
						</td>

						<td><span class="size1">难易程度</span>
							<%--for each的数组循环--%>
							<c:forEach begin="1" end="${eng.engineerDegree}" step="1">
								<span class="glyphicon glyphicon-star five"/>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td>
							<span class="size1">成长周期</span> &nbsp<span class="color-red">${eng.engineerGrowth}</span>年
						</td>
						<td>
							<span class="size1">稀缺程度</span>  &nbsp<span class="color-red">${eng.engineerScarcity}</span>家公司需要
						</td>
					</tr>
					<td colspan="2" class="outtd">
						<table class="intb">
							<tr>
								<td rowspan="3" class="bigtd">
									<span class="size1">薪资待遇</span>
								</td>
								<td class="longtd">
									<span>0-1年</span> <span>${eng.engineerSalaryOne}k-${eng.engineerSalaryThree}k/月</span>
								</td>
							</tr>
							<tr>
								<td class="longtd mintd">
									<span>1-3年</span> <span>${eng.engineerSalaryThree}k-${eng.engineerSalaryFive}k/月</span>
								</td>
							</tr>
							<tr>
								<td class="longtd">
									<span>3-5年</span> <span>${eng.engineerSalaryFive}k-无限k/月</span>
								</td>
							</tr>
						</table>
					</td>
					<tr>
						<td colspan="2">
							有<span class="color-red">${eng.engineerProceed}人</span>正在学
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<span class="size1">${eng.engineerTip}</span>
						</td>
					</tr>
				</table>
				<div class="hid">
					<p class="hid-t">ios工程师</p>
					<p class="hid-b">iOS是由苹果公司开发的移动操作系统。iOS与苹果的Mac OS X操作系统一样，属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</p>
				</div>
			</div>
		</div>
	</div>
</div>
<%--</main>--%>

