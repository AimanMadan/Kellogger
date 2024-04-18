package edu.csusm.kellogger.Services;

import edu.csusm.kellogger.Model.Space;
import edu.csusm.kellogger.Repository.ISpaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SpaceService implements ISpaceService{

    @Autowired private ISpaceRepository spaceRepository;

    @Override
    public List<Space> GetAllSpaces() {
        return spaceRepository.findAll(Sort.by(Sort.Direction.ASC, "nom"));
    }

    @Override
    public void AddPerson() {

    }

    @Override
    public void RemovePerson() {

    }

    @Override
    public int GetCount() {
        return 0;
    }
}
