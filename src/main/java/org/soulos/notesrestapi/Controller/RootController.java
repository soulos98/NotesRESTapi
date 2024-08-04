package org.soulos.notesrestapi.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.*;

@Controller
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public ResponseEntity<String> index() {
        JsonObject object = new JsonObject();
        object.addProperty("This is is okay", "okay");
        log.info("Pinged Server");
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

}
