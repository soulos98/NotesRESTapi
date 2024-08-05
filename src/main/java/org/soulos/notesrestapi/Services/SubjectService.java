package org.soulos.notesrestapi.Services;

import lombok.Getter;
import org.soulos.notesrestapi.Model.DatabaseSubjectNotes;
import org.soulos.notesrestapi.Model.Note;
import org.soulos.notesrestapi.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap; // import the HashMap class

@Getter
@Service
public class SubjectService {

    DatabaseSubjectNotes databaseSubjectNotes;

    public SubjectService(DatabaseSubjectNotes databaseSubjectNotes) {
        this.databaseSubjectNotes = databaseSubjectNotes;
    }

    /**
     * Retrieves all notes in a subject section
     * @param subjectName   Name of subject
     * @return              An {@code arrayList} of all the notes in the subject section
     */
    public Subject getSubjectNotes(String subjectName) {
        return databaseSubjectNotes.getNotesDatabase().get(subjectName.toUpperCase());
    }

    public boolean addSubject(Subject subject, String subjectName) {

        subject.setSubjectName(subjectName);
        databaseSubjectNotes.getNotesDatabase().put(subjectName.toUpperCase(), subject);


        return true;
    }


}
