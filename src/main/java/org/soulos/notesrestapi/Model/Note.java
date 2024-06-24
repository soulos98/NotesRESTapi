package org.soulos.notesrestapi.Model;

public class Note {
    String noteId;
    String noteContent;

    public Note(String noteId, String noteContent) {
        this.noteId = noteId;
        this.noteContent = noteContent;
    }

    public String getNoteName() {
        return noteId;
    }

    public void setNoteName(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

}
