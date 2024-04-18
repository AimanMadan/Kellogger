package edu.csusm.kellogger.Repository;

import edu.csusm.kellogger.Model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpaceRepository extends JpaRepository<Space, Integer> {
}
