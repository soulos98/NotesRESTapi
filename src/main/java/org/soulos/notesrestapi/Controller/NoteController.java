package org.soulos.notesrestapi.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soulos.notesrestapi.Model.Note;
import org.soulos.notesrestapi.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject/note/")
public class NoteController {

    private static final Logger log = LoggerFactory.getLogger(NoteController.class);
    NoteService noteService;

    @Autowired
    public NoteController (NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<String> postNote(@RequestParam("subjectName") String subjectName, @RequestBody Note note){
        log.info("Client attempting to post individual note for subject {}, noteConents: {}", subjectName, note);
        log.info("Endpoint POST: /subject/note/?subjectName={}&noteId={}", subjectName, note.getNoteId());
        boolean res = noteService.addNote(subjectName, note);
        String result = res ? "All went well note posted as should" : "Error occurred in note posting";
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Note> getNote(@RequestParam("subjectName") String subjectName, @RequestParam("noteId") String noteId){
        log.info("Client attempting to get individual note for subject {}, & noteId: {}", subjectName, noteId);
        log.info("Endpoint GET: /subject/note/?subjectName={}&noteId={}", subjectName, noteId);
        Note res = noteService.retrieveNote(subjectName, noteId);
        return ResponseEntity.ok(res);
    }


}
