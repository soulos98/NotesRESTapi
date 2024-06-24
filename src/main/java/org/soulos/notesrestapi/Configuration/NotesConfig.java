package org.soulos.notesrestapi.Configuration;


import org.soulos.notesrestapi.Services.SubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotesConfig {

    @Bean
    public SubjectService service(){
        return new SubjectService();
    }

}
