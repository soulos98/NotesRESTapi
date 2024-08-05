package org.soulos.notesrestapi.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.ArrayList;

@Data
public class Subject {

    String subjectName;

    @NotEmpty(message="Error notes section must not be empty")
    @Valid
    ArrayList<Note> notes = new ArrayList<>();

    public Subject(){
        subjectName = null;
    }

    public Subject(String subjectName, ArrayList<Note> notes) {
        this.subjectName = subjectName;
        this.notes = notes;
    }

    public void addNote(Note note) {
        notes.add(new Note(note.getNoteId().toUpperCase(), note.getNoteContent()));
    }

    public Note getNote(String noteId){
        return notes.stream().filter(note -> note.getNoteId().equals(noteId.toUpperCase())).findFirst().orElse(null);
    }



}
