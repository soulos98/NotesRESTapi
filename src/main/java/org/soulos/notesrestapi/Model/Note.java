package org.soulos.notesrestapi.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.soulos.notesrestapi.Configuration.Deserializer;

@Data
public class Note {

    @JsonDeserialize(using= Deserializer.class)
    @NotEmpty(message= "Error noteId is required.")
    @Size(min = 3, message = "NoteId is note valid")
    private String noteId;

    @NotEmpty(message= "Error noteContent must not be empty or NULL.")
    private String noteContent;

    public Note(){
        noteId = null;
        noteContent = null;
    }


    public Note(String noteId, String noteContent) {
        this.noteId = noteId;
        this.noteContent = noteContent;
    }

}
