package com.rt.mongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document
public class Book {

    @Id
    String id;

    String name;

    String isbn;

    Author author;
}
