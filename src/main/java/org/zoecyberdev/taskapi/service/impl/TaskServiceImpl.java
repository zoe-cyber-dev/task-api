package org.zoecyberdev.taskapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.zoecyberdev.taskapi.dto.TaskDto;
import org.zoecyberdev.taskapi.entity.Task;
import org.zoecyberdev.taskapi.exception.ResourceNotFoundException;
import org.zoecyberdev.taskapi.mapper.TaskMapper;
import org.zoecyberdev.taskapi.repository.TaskRepository;
import org.zoecyberdev.taskapi.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with given id: " + taskId));
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task) -> TaskMapper.mapToTaskDto(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with given id: " + taskId));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());

        Task updatedTaskObj = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with given id: " + taskId));

        taskRepository.deleteById(taskId);
    }


}
