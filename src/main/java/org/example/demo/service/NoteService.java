package org.example.demo.service;

import org.example.demo.entities.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        long nextId = generateUniqueId();
        nextId++;
        note.setId(nextId);
        notes.put(nextId, note);
        return note;
    }

    public void deleteById(long id) {
        if (notes.remove(id) == null) {
            throw new RuntimeException("Note with id = " + id + " doesn't exist!");
        } else {
            notes.remove(id);
        }
    }

    public void update(Note note) {
        final Long id = note.getId();
        if (notes.containsKey(id)) {
            Note currentNote = notes.get(id);
            currentNote.setTitle(note.getTitle());
            currentNote.setContent(note.getContent());
        } else {
            throw new RuntimeException("Note with id = " + note.getId() + " doesn`t exist!");
        }
    }

    public Note getById(long id) {
        return notes.get(id);
    }

    private long generateUniqueId() {
        long id;
        do {
            id = random.nextLong();
        } while (id <= 0 || notes.containsKey(id));
        return id;
    }

}