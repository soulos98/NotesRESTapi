package org.soulos.notesrestapi.Controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soulos.notesrestapi.Model.Subject;
import org.soulos.notesrestapi.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/subject")
public class SubjectController {

    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);
    SubjectService subjectService;

    @Autowired
    public SubjectController (SubjectService subjectService){
        this.subjectService = subjectService;
    }


    @GetMapping("/{subjectName}")
    public ResponseEntity<Subject> getSubjectNotes(@PathVariable String subjectName){
        log.info("Client attempting to get subject notes from server");
        log.info("Endpoint GET: /subject/{}", subjectName);
        Subject foundSubject = subjectService.getSubjectNotes(subjectName);

        return ResponseEntity.ok(foundSubject);
    }



    @PostMapping("/")
    public ResponseEntity<String> postSubjectNotes(@Valid @RequestBody Subject subjectNotes, @RequestParam("subjectName") String subjectName){
        log.info("Client attempting to post subject notes from server");
        log.info("Endpoint POST: /subject/?subjectName={}", subjectName);
        log.info("RequestBody: {}", subjectNotes);

        String res = subjectService.addSubject(subjectNotes, subjectName) ? "Successfully added subject note"
                : "Error occurred adding subject note";

        return ResponseEntity.ok(res);
    }
}
