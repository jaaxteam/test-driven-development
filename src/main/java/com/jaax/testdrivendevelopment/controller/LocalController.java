package com.jaax.testdrivendevelopment.controller;

import com.jaax.testdrivendevelopment.model.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/recurso")
public class LocalController {

    @PostMapping("/save")
    ResponseEntity<String> registerLocal(@RequestBody Local local){
        // TODO: Lógica para guardar el objeto Local en tu servicio
        String message = "Recurso creado exitosamente.";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping
    ResponseEntity<List<Local>> getAllLocals(){
        List<Local> localList = new ArrayList<>();
        for(long i = 1; i<=3; i++){
            Local local = new Local();
            local.setId(i);
            local.setName("Local " + i);
            local.setFloor("Floor "+ i);
            localList.add(local);
        }

        return ResponseEntity.ok(localList);
    }

}
