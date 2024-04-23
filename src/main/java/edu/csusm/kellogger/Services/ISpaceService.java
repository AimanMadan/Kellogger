package edu.csusm.kellogger.Services;

import edu.csusm.kellogger.Model.Space;
import java.util.List;
import java.util.Optional;

public interface ISpaceService {
    List<Space> getAllSpaces();
    Optional<Space> getSpace(int id);
    Space createSpace(Space space);
    void deleteSpace(int id);
    void addPerson(Space space);
    void removePerson(Space space);
    int getCount(Space space);
}
