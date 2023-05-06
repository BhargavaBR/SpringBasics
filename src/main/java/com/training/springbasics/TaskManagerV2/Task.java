package com.training.springbasics.TaskManagerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    int id;
    String name;
    @Setter
    Date dueDate;
    @Setter
    Boolean completed;
}
