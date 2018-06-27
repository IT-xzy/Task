package hzw.mapper;

import hzw.model.Profession;

import java.util.List;

public interface ProfessionMapper {
    void addProfession(Profession profession);

    void deleteProfession(Long proId);

    void updateProfession(Profession profession);

    Profession findIdProfession(Long proId);

    List<Profession> findListProfession();

    List<Profession> findNameProfession(String proName);
}
