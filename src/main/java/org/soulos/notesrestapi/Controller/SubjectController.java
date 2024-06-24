package org.soulos.notesrestapi.Controller;


import org.soulos.notesrestapi.Model.Note;
import org.soulos.notesrestapi.Model.Subject;
import org.soulos.notesrestapi.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.gson.*;


@Controller
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @GetMapping("/subject/{subjectName}")
    public void getSubjectNotes(@PathVariable String subjectName){
        System.out.println("/Subject (endpoint)");
        Subject foundSubject = subjectService.getSubjectNotes(subjectName);

        System.out.println(foundSubject.getSubjectName());
        for(Note note : foundSubject.getNotes()){
            System.out.println(note.getNoteName() + "\n" + "\t" + note.getNoteContent());
        }
    }


    @PostMapping("/subject/post")
    public void postSubjectNotes(@RequestBody Subject subject){
        System.out.println("/Subject (endpoint)");

        String res = subjectService.addSubject(subject) ? "Successfully added subject note" : "Error occurred adding subject note";
        System.out.println(res);


    }
}
