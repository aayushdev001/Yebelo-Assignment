package com.yebelo.assignment.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class FetchNumberResponseDTO
{
    int OldValue;
    int NewValue;
}
