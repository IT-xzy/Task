package jnshu.service.impl;

import jnshu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jnshu.dao.BannerMapper;
import jnshu.dao.CmenuMapper;
import jnshu.dao.SubmenuMapper;
import jnshu.model.Banner;
import jnshu.model.Cmenu;
import jnshu.model.Submenu;

import java.util.List;

@Service
public class MenuImpl implements MenuService {
    @Autowired
    CmenuMapper cmenuMapper;
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    SubmenuMapper submenuMapper;

    @Override
    public int deleteCmenuByPrimaryKey(Integer cmenuId) {
        return cmenuMapper.deleteByPrimaryKey (cmenuId);
    }

    @Override
    public int insertCmenu(Cmenu record) {
        return cmenuMapper.insert (record);
    }

    @Override
    public Cmenu selectCmenuByPrimaryKey(Integer cmenuId) {
        return cmenuMapper.selectByPrimaryKey (cmenuId);
    }

    @Override
    public int updateCmenuByPrimaryKeySelective(Cmenu record) {
        return cmenuMapper.updateByPrimaryKeySelective (record);
    }

//    查询菜单信息
    @Override
    public List selectMenu() {
        return cmenuMapper.selectMenu ();
    }

    @Override
    public int deleteBannerByPrimaryKey(Integer bannerId) {
        return bannerMapper.deleteByPrimaryKey (bannerId);
    }

    @Override
    public int insertBanner(Banner record) {
        return bannerMapper.insert (record);
    }

    @Override
    public Banner selectBannerByPrimaryKey(Integer bannerId) {
        return bannerMapper.selectByPrimaryKey (bannerId);
    }

    @Override
    public int updateBannerByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective (record);
    }

    //    联表查询banner的内容
    @Override
    public List selectBanner() {
        return bannerMapper.selectBanner ();
    }

    @Override
    public int deleteSubmenuByPrimaryKey(Integer submenuId) {
        return submenuMapper.deleteByPrimaryKey (submenuId);
    }

    @Override
    public int insertSubmenu(Submenu record) {
        return submenuMapper.insert (record);
    }

    @Override
    public Submenu selectSubmenuByPrimaryKey(Integer submenuId) {
        return submenuMapper.selectByPrimaryKey (submenuId);
    }

    @Override
    public int updateSubmenuByPrimaryKeySelective(Submenu record) {
        return submenuMapper.updateByPrimaryKeySelective (record);
    }
}
