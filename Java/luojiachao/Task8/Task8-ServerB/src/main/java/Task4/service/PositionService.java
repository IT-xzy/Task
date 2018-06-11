package Task4.service;

import Task4.pojo.Position;

import java.util.List;

public interface PositionService {
    Position findById(int id);

    Position findByClass(String classes);

    List<Position> list();

    int findAll();
}
