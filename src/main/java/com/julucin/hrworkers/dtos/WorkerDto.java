package com.julucin.hrworkers.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerDto {

    private Long id;
    private String name;
    private Double dailyIncome;

}
