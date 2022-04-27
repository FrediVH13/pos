package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.Tag;
import com.fredivazquez.pos.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService{

    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tag> getTags() {
        return repository.findAll();
    }
}
