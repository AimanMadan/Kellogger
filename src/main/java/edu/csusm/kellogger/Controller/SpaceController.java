package edu.csusm.kellogger.Controller;

import edu.csusm.kellogger.Model.Space;
import edu.csusm.kellogger.Services.ISpaceService;
import edu.csusm.kellogger.Services.SpaceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/spaces")
public class SpaceController {
    @Autowired public ISpaceService spaceService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Space>> getAllSpaces(){
        return ResponseEntity.ok(spaceService.getAllSpaces());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Space> getSpace(@PathVariable int id){
        var space = spaceService.getSpace(id);
        return space.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<Space> createSpace(@RequestBody Space space){
        return ResponseEntity.ok(spaceService.createSpace(space));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Space> deleteSpace(@PathVariable int id){
        var space = spaceService.deleteSpace(id);
        return space != null ? ResponseEntity.ok(space) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/addPerson")
    public ResponseEntity<Space> addPerson(@PathVariable int id){
        return ResponseEntity.ok(spaceService.addPerson(id));
    }
    @PostMapping("/{id}/removePerson")
    public ResponseEntity<Space> removePerson(@PathVariable int id){
        return ResponseEntity.ok(spaceService.removePerson(id));
    }
}
