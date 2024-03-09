package com.example.hw16.servicies;


import com.example.hw16.data.reprository.NoteRepository;
import com.example.hw16.servicies.dto.NoteDto;
import com.example.hw16.servicies.mapper.MapperNotes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final MapperNotes noteMapper;

    //повертає список всіх нотаток
    public List<NoteDto> getAllNotes(){
        return noteMapper.toNoteDtoList(noteRepository.findAll());
    }

    //додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором.
    public NoteDto addNote(NoteDto noteDto){ return noteMapper.toNoteDto(noteRepository.saveAndFlush(noteMapper.toNote(noteDto)));}

    //видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    public void deleteById(UUID id) throws Exception {
        noteRepository.deleteById(id);
    }

    //шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    public void update(NoteDto note) throws Exception {
        if(noteRepository.existsById(note.getId())){
            noteRepository.updateNote(note.getId(), note.getTitle(), note.getContent());
        }else{
            throw new Exception("No ID");
        }
    }

    //повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    public NoteDto getById(UUID id) throws Exception {
        return noteMapper.toNoteDto(noteRepository.getById(id));
    }
}
