package Task4.mapper;

import Task4.pojo.Position;

import java.util.List;

public interface PositionMapper {
    Position findById(int id);

    Position findByClass(String classes);

    List<Position> list();

    int findAll();
}
