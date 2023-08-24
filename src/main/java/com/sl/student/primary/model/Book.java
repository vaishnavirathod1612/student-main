package com.sl.student.primary.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Library")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    int bookId;
    String bookName;
    String bookType;
    String bookAuthor;
}
