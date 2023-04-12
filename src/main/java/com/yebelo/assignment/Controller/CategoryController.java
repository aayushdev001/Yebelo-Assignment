package com.yebelo.assignment.Controller;

import com.yebelo.assignment.DTO.FetchNumberResponseDTO;
import com.yebelo.assignment.Model.Category;
import com.yebelo.assignment.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fetchNextNumber")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @GetMapping("")
    public FetchNumberResponseDTO fetchNextNumber(@RequestParam String category)
    {
        return categoryService.fetchNextNumber(category);
    }
}
