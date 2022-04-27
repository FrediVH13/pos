package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.ProductTag;
import com.fredivazquez.pos.models.Tag;
import com.fredivazquez.pos.services.IProductTagService;
import com.fredivazquez.pos.services.ITagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class ProductTagController {

    private final ITagService tagService;

    public ProductTagController(ITagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> allTags() {
        return tagService.getTags();
    }
}
