package com.example.hw16.controller;


import com.example.hw16.servicies.dto.NoteDto;
import com.example.hw16.servicies.NoteService;
import com.example.hw16.servicies.mapper.MapperNotes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private MapperNotes noteMapper;
    @GetMapping(value = "/list")
    public ModelAndView listOfNotes() {
        ModelAndView result = new ModelAndView("notes/notesMainPage");
        result.addObject("notes", noteService.getAllNotes());
        return result;
    }

    @PostMapping(value = "/add")
    public String addNote(@NotEmpty @RequestParam(name = "title") String title,
                          @NotEmpty @RequestParam(name = "content") String content){
        NoteDto note = new NoteDto();
        note.setTitle(title);
        note.setContent(content);
        noteService.addNote(note);
        return "redirect:/note/list";
    }


    @GetMapping(value = "/edit")
    public ModelAndView getNoteForEdit(@NotEmpty @RequestParam(name = "id") String id) throws Exception {
        UUID uuid = UUID.fromString(id);
        ModelAndView result = new ModelAndView("notes/noteEdit");
        result.addObject("note", noteService.getById(uuid));
        return result;
    }

    @PostMapping(value = "/edit")
    public String editNote(@ModelAttribute NoteDto ndto) throws Exception {
        noteService.update(ndto);
        return "redirect:/note/list";
    }

    @PostMapping(value = "/delete")
    public String deleteNote(@RequestParam(name = "id") String id) throws Exception {
        UUID uuid = UUID.fromString(id);
        noteService.deleteById(uuid);
        return "redirect:/note/list";
    }



}
