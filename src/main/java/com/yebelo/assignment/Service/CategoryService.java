package com.yebelo.assignment.Service;

import com.yebelo.assignment.DTO.FetchNumberResponseDTO;
import com.yebelo.assignment.Model.Category;
import com.yebelo.assignment.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category)
    {
        categoryRepository.save(category);
        return category;
    }

    public FetchNumberResponseDTO fetchNextNumber(String category)
    {
        Category c = categoryRepository.findById(category).get();
        int value = c.getValue();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int nextNumber = calculateNextNumber(value);
        c.setValue(nextNumber);
        categoryRepository.save(c);

        return FetchNumberResponseDTO.builder().OldValue(value).NewValue(nextNumber).build();
    }

    private int calculateNextNumber(int value)
    {
        int nextNumber = value + 1;
        while (sumDigits(nextNumber) != 1)
        {
            nextNumber++;
        }
        return nextNumber;
    }

    private int sumDigits(int number)
    {
        int sum = 0;
        while (number != 0)
        {
            sum += number % 10;
            number /= 10;
        }
        if(sum>9) return sumDigits(sum);
        return sum;

    }
}
