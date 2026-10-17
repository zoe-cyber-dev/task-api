package org.zoecyberdev.taskapi.mapper;

import org.zoecyberdev.taskapi.dto.TaskDto;
import org.zoecyberdev.taskapi.entity.Task;

public class TaskMapper {

    // Task -> TaskDto
    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

    // TaskDto -> Task
    public static Task mapToTask(TaskDto taskDto){
        Task task = new Task();

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(false);

        return task;
    }

}
