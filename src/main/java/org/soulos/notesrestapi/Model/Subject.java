package org.soulos.notesrestapi.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Subject {

    String subjectName;

    @Valid
    ArrayList<Note> notes = new ArrayList<>();

    public Subject(){
        subjectName = null;
    }

    public Subject(String subjectName, ArrayList<Note> notes) {
        this.subjectName = subjectName;
        this.notes = notes;
    }


    public void addNote(String noteId, String noteContent) {
        notes.add(new Note(noteId.toLowerCase(), noteContent));
    }

    public Note getNote(String noteId){
        return notes.stream().filter(note -> note.getNoteId().equals(noteId.toLowerCase())).findFirst().orElse(null);
    }



}
