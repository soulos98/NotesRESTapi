package org.soulos.notesrestapi.Services;

import lombok.Getter;
import org.soulos.notesrestapi.Model.Note;
import org.soulos.notesrestapi.Model.Subject;
import org.springframework.stereotype.Service;

import java.util.HashMap; // import the HashMap class

@Getter
@Service
public class SubjectService {

    private final HashMap<String, Subject> allNotes = new HashMap<>(); // TODO: SWAP with a real DB

    /**
     * Retrieves all notes in a subject section
     * @param subjectName   Name of subject
     * @return              An {@code arrayList} of all the notes in the subject section
     */
    public Subject getSubjectNotes(String subjectName) {
        return allNotes.get(subjectName.toUpperCase());
    }

    public boolean addSubject(Subject subject, String subjectName) {
        if(subject == null)
            return false;

        subject.setSubjectName(subjectName);

        allNotes.put(subjectName.toUpperCase(), subject);
        return true;
    }

    /**
     * Validates that subject name exists, & the note you're attempting to grab exists
     * @param subjectName   Subject name of  object
     * @param noteId        Note id of note
     * @param noteContent   Note body
     * @return              {@code true} if parameters are valid
     */
    private boolean validateParameters(String subjectName, String noteId, String noteContent){
        return allNotes.containsKey(subjectName) && allNotes.get(subjectName).getNote(noteId)
                != null && noteContent != null;
    }

    /**
     * Adds a note to a subject
     * @param subjectName   Name of subject
     * @param noteId        ID of note
     * @param noteContent   Body of note
     * @return              {@code true} if successful addition of note
     */
    public boolean addNote(String subjectName, String noteId, String noteContent){
        boolean res = validateParameters(subjectName.toUpperCase(), noteId.toLowerCase(), noteContent);

        // 400 error
        if(!res)
            return res;

        try{
            allNotes.get(subjectName).addNote(noteId, noteContent);
        } catch (Exception e){
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    /**
     * Retrieves a note using the subject name & noteId
     * @param subjectName   Name of the subject we're interested in receiving
     * @param noteId        ID of note we're interested in retrieving
     * @return              {@code Note} object
     */
    public Note getNote(String subjectName, String noteId){
        return getAllNotes().get(subjectName.toUpperCase()).getNote(noteId.toLowerCase());
    }

}
