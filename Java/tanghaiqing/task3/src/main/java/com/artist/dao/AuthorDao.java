package com.artist.dao;

import com.artist.pojo.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> queryAuthors();
    Author queryAuthor(String authorName);
    void saveAuthor(Author author);
    void delAuthor(Integer id);
    void updateAuthor(Author author);
}
