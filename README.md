# TaskTracker
Task Manager With Java
# Task Tracker CLI

Task Tracker is a simple and efficient Command-Line Interface (CLI) application for managing tasks. It allows users to add, list, update, sort and delete tasks with ease.

## Features
- Add new tasks with a title and description
- List all tasks
- Update task details
- Delete tasks
- Persist tasks using JSON files

## Prerequisites
Ensure you have the following installed:
- **Java 17** or later
- **Maven** (for building the project)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/sapphire0602/TaskTracker.git
   cd to the current directory
   ```

2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

3. Navigate to the `target/` directory:
   ```sh
   cd target
   ```

4. Run the application:
   ```sh
   java -jar ./TaskTracker-jar-with-dependencies.jar 
   ```

## Usage
### Adding a Task
```sh
add (In any case {upper/lower})
```

### Listing All Tasks
```sh
list-all (In any case {upper/lower})
```

### Sorting
```sh
sort (In any case {upper/lower})
```
### Updating Task Status
```sh
update-status (In any case {upper/lower})
```
### Removing All Tasks
```sh
remove-all (In any case {upper/lower})
```

### Updating a Task
```sh
update (In any case {upper/lower})
```

### Deleting a Task
```sh
delete (In any case {upper/lower})
```

### Exiting Application
```sh
exit (In any case {upper/lower})
```

## File Storage
The application stores tasks in a JSON file (`TaskFileList.json`) within the project directory, and used for persistence .

## Contributing
Feel free to submit issues and pull requests to improve the Task Tracker.


