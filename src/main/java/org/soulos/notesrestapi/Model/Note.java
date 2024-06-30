package org.soulos.notesrestapi.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Note {

    @Pattern(regexp = "^(?!.*\\s).+$", message = "No spaces allowed in your noteID.")
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
