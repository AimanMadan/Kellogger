package edu.csusm.kellogger.Services;

import edu.csusm.kellogger.Model.Space;
import java.util.List;
import java.util.Optional;

public interface ISpaceService {
    List<Space> getAllSpaces();
    Optional<Space> getSpace(int id);
    Space createSpace(Space space);
    Space deleteSpace(int id);
    Space addPerson(int id);
    Space removePerson(int id);
    int getCount(Space space);
}
