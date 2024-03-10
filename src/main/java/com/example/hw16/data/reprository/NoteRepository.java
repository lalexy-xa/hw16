package com.example.hw16.data.reprository;


import com.example.hw16.data.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository

public interface NoteRepository extends JpaRepository<Note, UUID> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value ="UPDATE note SET title=:title, content=:content WHERE id=:id")
    public void updateNote(@Param("id") UUID id,
                           @Param("title") String title,
                           @Param("content") String content);


}
