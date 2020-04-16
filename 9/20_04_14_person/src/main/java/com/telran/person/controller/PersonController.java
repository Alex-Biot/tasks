package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void createPerson(@RequestBody @Valid PersonDto personDto) {
        personService.create(personDto);
    }

    @PutMapping("/person")
    public void editPerson(@RequestBody @Valid PersonDto personDto) {
        personService.edit(personDto);
    }

    @GetMapping("/person")
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public PersonDto getPersonById(@PathVariable int id) {
        return personService.getById(id);
    }

    @DeleteMapping("/person/{id}")
    public void removePerson(@PathVariable int id) {
        personService.removeById(id);
    }

    @GetMapping("/person/name/{name}")
    public List<PersonDto> getByName(@PathVariable(value = "name") String firstName) {
        return personService.getByName(firstName);
    }

    @GetMapping("/person/age")
    public List<PersonDto> filterByAge(
            @RequestParam(defaultValue = "0") int min,
            @RequestParam(defaultValue = "" + Integer.MAX_VALUE) int max) {
        return personService.filterByAge(min, max);
    }
}
