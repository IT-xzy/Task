package com.artist.service;

import com.artist.pojo.Production;

import java.util.List;

public interface SearchService {
    List<Production> keywordSearch(String word);
    List<Production> categorySearch(String category);
}
