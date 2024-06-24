package org.soulos.notesrestapi.Model;

import java.util.ArrayList;

public class Subject {
    String subjectName;
    ArrayList<Note> notes = new ArrayList<>();

    public Subject(String subjectName, ArrayList<Note> notes) {
        this.subjectName = subjectName;
        this.notes = notes;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }


    public boolean addNote(String noteId, String noteContent) {
        notes.add(new Note(noteId.toLowerCase(), noteContent));
        return true;
    }

    public Note getNote(String noteId){
        return notes.stream().filter(note -> note.noteId.equals(noteId.toLowerCase())).findFirst().orElse(null);
    }



}
