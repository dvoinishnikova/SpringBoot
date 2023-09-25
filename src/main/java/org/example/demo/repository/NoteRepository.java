package org.example.demo.repository;

import org.example.demo.entities.Note;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}