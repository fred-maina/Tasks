# Task Management API

## Overview
The Task Management API is a Spring Boot application that allows users to manage tasks efficiently. Users can create, read, update, and delete tasks through a RESTful API.

## Features
- **Create a Task**: Add a new task to the list.
- **Read Tasks**: Retrieve all tasks or a specific task by ID.
- **Update a Task**: Partially update an existing task.
- **Delete a Task**: Remove a task from the list.

## Technologies Used
- **Java Version**: 21
- **Spring Boot**: 3.3.5
- **Spring Data JPA**: For database interactions
- **H2 Database**: In-memory database for development and testing

## API Endpoints
The following endpoints are available for interacting with the task management system:

### 1. Get All Tasks
- **Endpoint**: `GET /tasks`
- **Description**: Retrieves a list of all tasks.
- **Response**:
  - **200 OK**: Returns a JSON array of tasks.

### 2. Get Task by ID
- **Endpoint**: `GET /tasks/{id}`
- **Description**: Retrieves a specific task by its ID.
- **Parameters**:
  - `id` (long): The ID of the task.
- **Response**:
  - **200 OK**: Returns the task details.
  - **404 Not Found**: If the task with the specified ID does not exist.

### 3. Create a Task
- **Endpoint**: `POST /tasks/create`
- **Description**: Creates a new task.
- **Request Body**:
  ```json
  {
      "name": "Task Name",
      "description": "Task Description",
      "completed": false
  }
  ```
- **Response**:
    - **201 Created**: Returns the created task details.

### 4. Delete a Task
- **Endpoint**: `DELETE /tasks/delete/{id}`
- **Description**: Deletes a specific task by its ID.
- **Parameters**:
    - `id` (long): The ID of the task.
- **Response**:
    - **204 No Content**: If the deletion is successful.
    - **404 Not Found**: If the task with the specified ID does not exist.

### 5. Update a Task
- **Endpoint**: `PATCH /tasks/update/{id}`
- **Description**: Updates an existing task partially.
- **Parameters**:
    - `id` (long): The ID of the task.
- **Request Body** (fields to update can be omitted):
  ```json
  {
      "name": "Updated Task Name",
      "description": "Updated Task Description",
      "completed": true
  }
  ```
- **Response**:
    - **200 OK**: Returns the updated task details.
    - **404 Not Found**: If the task with the specified ID does not exist.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Version 21 or later
- **Maven**: For building the project

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/task-management-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd task-management-api
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Running the Application
To run the Spring Boot application, use the following command:
```bash
mvn spring-boot:run
```
The application will start on `http://localhost:8080`.

### Testing the API
You can use tools like **Postman** or **curl** to test the API endpoints.

### Example Commands
1. **Create a Task**:
   ```bash
   curl -X POST http://localhost:8080/tasks/create -H "Content-Type: application/json" -d '{"name": "Sample Task", "description": "This is a sample task", "completed": false}'
   ```
2. **Get All Tasks**:
   ```bash
   curl http://localhost:8080/tasks
   ```
3. **Get Task by ID**:
   ```bash
   curl http://localhost:8080/tasks/1
   ```
4. **Update a Task**:
   ```bash
   curl -X PATCH http://localhost:8080/tasks/update/1 -H "Content-Type: application/json" -d '{"completed": true}'
   ```
5. **Delete a Task**:
   ```bash
   curl -X DELETE http://localhost:8080/tasks/delete/1
   ```
