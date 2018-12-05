package task9.service;

import org.oasisopen.sca.annotation.Remotable;
import task9.pojo.PositionStu;

import java.util.List;

@Remotable
public interface PositionService {
    List<PositionStu> goodShowService();
}
