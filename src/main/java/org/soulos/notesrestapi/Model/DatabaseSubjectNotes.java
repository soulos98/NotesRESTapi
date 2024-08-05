package org.soulos.notesrestapi.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component
public class DatabaseSubjectNotes {
    public HashMap<String, Subject> notesDatabase; // TODO: SWAP with a real DB

    public DatabaseSubjectNotes() {
        notesDatabase = new HashMap<>();
    }

}
