package com.example.hw16.servicies.mapper;

import com.example.hw16.data.entities.Note;
import com.example.hw16.servicies.dto.NoteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperNotes {

    public Note toNote(NoteDto ndto){
        Note note = new Note();
        note.setId(ndto.getId());
        note.setTitle(ndto.getTitle());
        note.setContent(ndto.getContent());
        return  note;
    }

    public NoteDto toNoteDto(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        return  noteDto;
    }

    public List<NoteDto> toNoteDtoList(List<Note> notes){
        return notes.stream()
                .map(a -> toNoteDto(a))
                .collect(Collectors.toList());
    }

}
