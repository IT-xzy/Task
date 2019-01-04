package task9.service;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface StudentService {
     Integer countService();
     Integer countJobService();
}
