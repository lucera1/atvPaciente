package com.curso.resources;

import com.curso.domains.Medico;
import com.curso.domains.dtos.MedicoDTO;
import com.curso.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoResource {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(){
        return ResponseEntity.ok().body(medicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Integer id){
        Medico obj = this.medicoService.findbyId(id);
        return ResponseEntity.ok().body(new MedicoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> create(@Valid @RequestBody MedicoDTO dto){
        Medico medico = medicoService.create(dto);
        //Cria a URI para o recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(medico.getId()).toUri();
        //Retorna a resposta com o status 201 Created e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> update(@PathVariable Integer id, @Valid @RequestBody MedicoDTO objDto){
        Medico Obj = medicoService.update(id,objDto);
        return ResponseEntity.ok().body(new MedicoDTO(Obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> delete(@PathVariable Integer id){
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

