package edu.csusm.kellogger.Services;

import edu.csusm.kellogger.Model.Space;
import java.util.List;

public interface ISpaceService {
    List<Space> GetAllSpaces();
    void AddPerson();
    void RemovePerson();
    int GetCount();
}
