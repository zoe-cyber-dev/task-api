package org.zoecyberdev.taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;

    @NotBlank(message = "A task's tittle cannot be blank")
    @Size(max = 100, message = "A task's tittle cannot exceed the 100 character limit")
    private String title;

    private String description;

    private Boolean completed;
}
