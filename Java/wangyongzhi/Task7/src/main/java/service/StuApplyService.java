package service;


import domain.entity.StuApply;

public interface StuApplyService {

    public int insert(StuApply stuApply);

    public int selectCount();

    public StuApply getByUsername(String username);

    public StuApply getByPhone(String telephone);

    public int updateByUsername(StuApply stuApply);

}
