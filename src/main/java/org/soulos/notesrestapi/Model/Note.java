package org.soulos.notesrestapi.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Note {
    @JsonDeserialize(using= Deserializer.class)
    private String noteId;
    private String noteContent;

    public Note(){
        noteId = null;
        noteContent = null;
    }


    public Note(String noteId, String noteContent) {
        this.noteId = noteId;
        this.noteContent = noteContent;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

}
