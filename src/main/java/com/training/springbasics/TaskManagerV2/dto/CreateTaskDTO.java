package com.training.springbasics.TaskManagerV2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CreateTaskDTO {
    String name;
    Date dueDate;

}
