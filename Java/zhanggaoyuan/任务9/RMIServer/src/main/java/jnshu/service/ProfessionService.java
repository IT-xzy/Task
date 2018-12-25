package jnshu.service;

import jnshu.model.Profession;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface ProfessionService {

    int insert(Profession record);

    List selectProfession();
}
