package edu.csusm.kellogger;

import edu.csusm.kellogger.Model.Space;
import edu.csusm.kellogger.Repository.ISpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KelloggerApplication implements CommandLineRunner {
    @Autowired ISpaceRepository spaceRepository;

    public static void main(String[] args) {
        SpringApplication.run(KelloggerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Space library = new Space(0,"library", "Kellogg Library", 0, 1000, 0, 2,0);
        spaceRepository.save(library);
    }
}
