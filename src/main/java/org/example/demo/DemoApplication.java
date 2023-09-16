package org.example.demo;

import org.example.demo.entities.Note;
import org.example.demo.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		NoteService noteService = context.getBean(NoteService.class);

		// Додавання та виведення записів
		Note note1 = new Note("Title1", "Context1");
		noteService.add(note1);
		System.out.println("Added note: " + note1);

		Note note2 = new Note("Title2", "Context2");
		noteService.add(note2);
		System.out.println("Added note: " + note2);

		// Отримання всіх записів
		List<Note> allNotes = noteService.listAll();
		System.out.println("All notes: " + allNotes);

	}

}
