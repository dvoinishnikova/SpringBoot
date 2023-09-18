package org.example.demo.entities;

import lombok.*;

@Data
@Getter
@Setter
@ToString
public class Note {

    private Long id;
    private String title;
    private String content;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


}