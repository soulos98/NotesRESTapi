package org.soulos.notesrestapi.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soulos.notesrestapi.Model.DatabaseSubjectNotes;
import org.soulos.notesrestapi.Model.Note;
import org.soulos.notesrestapi.Model.Subject;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private static final Logger log = LoggerFactory.getLogger(NoteService.class);
    DatabaseSubjectNotes databaseSubjectNotes;

    public NoteService(DatabaseSubjectNotes databaseSubjectNotes) {
        this.databaseSubjectNotes = databaseSubjectNotes;
    }


    public boolean addNote(String subjectName, Note note){
        subjectName = subjectName.trim();

        Subject subject =  databaseSubjectNotes.getNotesDatabase().get(subjectName.toUpperCase());

        if(subject == null){
            log.info("Subject " + subjectName + " not found");
            subject = new Subject();
            databaseSubjectNotes.getNotesDatabase().put(subjectName.toUpperCase(),subject);
            log.info("Subject " + subjectName + " added");
        }

        subject.addNote(note);
        databaseSubjectNotes.getNotesDatabase().put(subjectName.toUpperCase(),subject);

        return true;
    }

    public Note retrieveNote(String subjectName, String noteId){
        subjectName=subjectName.trim();
        noteId=noteId.trim();

        Note note = databaseSubjectNotes.getNotesDatabase().get(subjectName.toUpperCase()).getNote(noteId.toUpperCase());
        if(note == null){
            log.info("Note " + noteId + " not found");
        } else
            log.info("Note " + noteId + " found");
        return note;
    }
}
