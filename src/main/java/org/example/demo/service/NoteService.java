package org.example.demo.service;

import org.example.demo.entities.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> noteMap = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        long id = generateUniqueId();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        Optional<Note> note = getNoteById(id);
        note.ifPresentOrElse(
                n -> noteMap.remove(id),
                () -> {
                    throw new RuntimeException("Note with ID " + id + " not found");
                }
        );
    }

    public void update(long id, Note updatedNote) {
        Optional<Note> existingNote = getNoteById(id);
        existingNote.ifPresentOrElse(
                n -> {
                    if (n.getId() != null) { // Перевіряємо, чи ID не є null
                        n.setTitle(updatedNote.getTitle());
                        n.setContent(updatedNote.getContent());
                        noteMap.put(id, n);
                    } else {
                        throw new RuntimeException("Note with ID " + id + " has a null ID");
                    }
                },
                () -> {
                    throw new RuntimeException("Note with ID " + id + " not found");
                }
        );
    }

    public Optional<Note> getById(long id) {
        return Optional.ofNullable(noteMap.get(id));
    }

    private long generateUniqueId() {
        long id;
        do {
            id = random.nextLong();
        } while (id <= 0 || noteMap.containsKey(id));
        return id;
    }

    private Optional<Note> getNoteById(long id) {
        return Optional.ofNullable(noteMap.get(id));
    }
}