package org.soulos.notesrestapi.Configuration;


import org.soulos.notesrestapi.Model.DatabaseSubjectNotes;
import org.soulos.notesrestapi.Services.NoteService;
import org.soulos.notesrestapi.Services.SubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotesConfig {

    DatabaseSubjectNotes databaseSubjectNotes = new DatabaseSubjectNotes();

    @Bean
    public SubjectService subjectService(){
        return new SubjectService(databaseSubjectNotes);
    }

    @Bean
    public NoteService noteService(){
        return new NoteService(databaseSubjectNotes);
    }

}
