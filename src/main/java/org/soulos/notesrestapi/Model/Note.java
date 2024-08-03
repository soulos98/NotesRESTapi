package org.soulos.notesrestapi.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.soulos.notesrestapi.Configuration.Deserializer;

@Setter
@Getter
@Data
public class Note {

    @JsonDeserialize(using= Deserializer.class)
    @NotEmpty(message= "Error noteId must not be empty or NULL.")
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
