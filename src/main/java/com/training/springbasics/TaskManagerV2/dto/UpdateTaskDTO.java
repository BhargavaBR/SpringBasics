package com.training.springbasics.TaskManagerV2.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDTO {
    Date dueDate;
    Boolean completed;

}
