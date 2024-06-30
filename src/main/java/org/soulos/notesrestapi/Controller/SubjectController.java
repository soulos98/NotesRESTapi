package org.soulos.notesrestapi.Controller;


import jakarta.validation.Valid;
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

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }

    SubjectService subjectService;

    @Autowired
    public SubjectController (SubjectService subjectService){
        this.subjectService = subjectService;
    }


    @GetMapping("/{subjectName}")
    public ResponseEntity<Subject> getSubjectNotes(@PathVariable String subjectName){
        System.out.println("/subject/{subjectName} (GET endpoint)");
        Subject foundSubject = subjectService.getSubjectNotes(subjectName);

        return ResponseEntity.ok(foundSubject);
    }


    @PostMapping("/{subjectName}")
    public ResponseEntity<String> postSubjectNotes(@Valid @RequestBody Subject subjectNotes, @PathVariable String subjectName){
        System.out.println("/subject/{subjectName} (POST endpoint)");

        String res = subjectService.addSubject(subjectNotes, subjectName) ? "Successfully added subject note"
                : "Error occurred adding subject note";

        return ResponseEntity.ok(res);
    }
}
