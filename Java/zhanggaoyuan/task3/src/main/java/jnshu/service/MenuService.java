package jnshu.service;

import jnshu.model.Banner;
import jnshu.model.Cmenu;
import jnshu.model.Submenu;

import java.util.List;

public interface MenuService {
//    Cmenu
    int deleteCmenuByPrimaryKey(Integer cmenuId);

    int insertCmenu(Cmenu record);

    Cmenu selectCmenuByPrimaryKey(Integer cmenuId);

    int updateCmenuByPrimaryKeySelective(Cmenu record);

    //    查询菜单信息
    List selectMenu();
//    Banner
    int deleteBannerByPrimaryKey(Integer bannerId);

    int insertBanner(Banner record);

    Banner selectBannerByPrimaryKey(Integer bannerId);

    int updateBannerByPrimaryKeySelective(Banner record);
    //    联表查询banner的内容
    List selectBanner ();

//    Submenu
    int deleteSubmenuByPrimaryKey(Integer submenuId);

    int insertSubmenu(Submenu record);

    Submenu selectSubmenuByPrimaryKey(Integer submenuId);

    int updateSubmenuByPrimaryKeySelective(Submenu record);
}
