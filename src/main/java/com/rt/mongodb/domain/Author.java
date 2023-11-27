package com.rt.mongodb.domain;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Author {
    String name;
    int age;
}
