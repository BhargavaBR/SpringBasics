package com.training.springbasics.TaskManagerV2.dto;

import com.training.springbasics.TaskManagerV2.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDTO {
    private Task task;
    private String Error;
    private String result;
}
