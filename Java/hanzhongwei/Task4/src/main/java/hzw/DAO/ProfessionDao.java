package hzw.DAO;

import hzw.model.Profession1;

import java.util.List;

public interface ProfessionDao {
    Profession1 findByIdProfession(int id);
    List<Profession1> findByListProfession();
}
