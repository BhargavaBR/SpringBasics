package com.training.springbasics.TaskManagerV2.Exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponseDTO {
    int Status;
    String Error;
}
