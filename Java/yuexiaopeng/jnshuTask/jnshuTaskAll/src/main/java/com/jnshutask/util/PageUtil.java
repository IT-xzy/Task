package com.jnshutask.util;

import org.springframework.stereotype.Component;

@Component
public class PageUtil {

    /**获得page信息
     * @param pageNum  页码数；
     * @param pageSize 每页数目
     * @param count    需要分页的总数量
     * @return 返回包括首页，上一页，下一页，末页，总数的page队象；
     */
    public Page getPageInfo(Integer pageNum, Integer pageSize, Long count) {
        Page page = new Page();
        //保证pagenum有默认值；不符合条件的情况返回首页；
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        //保证psgeSize的值
        if (pageSize == null || pageSize <= 0 || pageSize > 10) {
            pageSize = 5;
        }
        //保证pageNum与pageSize的和小于count
        if ((pageNum * pageSize) > count) {
            //大于的话，将pageNum设置为末页
            pageNum = count.intValue() / pageSize + 1;
            if (count.intValue() % pageSize == 0) {
                pageNum = count.intValue() / pageSize;
            }
        }
        //计算末页数，整除情况需要改变
        Integer pageFinal = count.intValue() / pageSize + 1;
        if (count.intValue() % pageSize == 0) {
            pageFinal = count.intValue() / pageSize;
        }
        //计算每页开始的条数和最后一天，末页情况需要改变
        Integer pageNumStart = pageNum * pageSize - pageSize;
        Integer pageNumEnd = pageNumStart + pageSize;
        if (pageNumEnd >= count) {
            pageNumEnd = count.intValue();
        }

        //计算相关的几个参数；
        Integer pageHome = 1;
        //计算下一页，最大为pageFinal
        Integer pageNext = pageNum + 1;
        if (pageNum == pageFinal) {
            pageNext = pageFinal;
        }
        //计算上一页，最小为1；
        Integer pageLast = pageNum - 1;
        if (pageLast == 0) {
            pageLast = pageNum;
        }

        page.setPageNum(pageNum);
        page.setPageHome(pageHome);
        page.setPageLast(pageLast);
        page.setPageNext(pageNext);
        page.setPageFinal(pageFinal);
        page.setPageNumTotal(pageNumEnd - pageNumStart);
        return page;
    }
}
