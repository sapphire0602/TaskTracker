package com.tasktracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JSONHandler.createJsonFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=-=-=-=-=-=- WELCOME TO TASK TRACKER CLI APP =-=-=-=-=-=");

        while (true){
            System.out.println("=*=*=*=* [ ENTER A COMMAND { Add || Delete || List-all || SortByStatus(Sort) || Update || Exit || Update-status || RemoveAllTasks (remove-all) } ] =*=*=*=*");
            String command = scanner.nextLine().trim().toLowerCase();
            switch(command) {
                case "add":
                    System.out.println("Enter Task Description : ");
                    StringBuilder description = new StringBuilder();
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) {
                        description.append(input);
                        AddTask.addTask(description.toString().trim());
                    }else
                        System.out.println("Task description can't be empty!");
                    break;

                case "update":
                    System.out.println("Enter the 'ID' of the task you want to update [NOTE : press enter twice after entering TaskID to enter task description] :");
                    StringBuilder desc = new StringBuilder();
                    int taskId2 = getValidInteger(scanner);
                    scanner.nextLine();
                    System.out.println("Enter Task Description (New One || Might be old one also) : ");
                    String input1 = scanner.nextLine();
                    if (!input1.isEmpty() && taskId2 !=-1) {
                        desc.append(input1);
                        UpdateTasks.updateTask(taskId2,input1);
                    }else
                        System.out.println("Task description can't be empty !");
                    break;

                case "delete" :
                    System.out.println("Enter the ID of the task to delete : ");
                    int taskId = getValidInteger(scanner);
                    if (taskId!=-1) {
                        DeleteTasks.deleteTask(taskId);
                    }else
                        System.out.println("Task ID cannot be negative!");
                    break;

                case "list-all" :
                    System.out.println(ListTasks.listAllTasks());
                    break;

                case "sort" :
                    System.out.println("Enter status of task to sort [to-do , in-progress , completed] ");
                    String status = scanner.nextLine().trim().toLowerCase();
                    System.out.println("=-=-SORTING BY STATUS=-=-");
                    System.out.println(ListTasks.filterByStatus(status));
                    break;

                case "update-status":
                    System.out.println("Enter the ID of the task you want to update its status : ");
                    int task_id = getValidInteger(scanner);
                    System.out.println("Enter what you want the updated status to be {to-do , in-progress , completed} : ");
                    String status1 = scanner.nextLine().trim().toLowerCase();
                    TaskStatus.markStatus(task_id,status1);
                    break;

                case "remove-all":
                    System.out.println("Going to delete all tasks");
                    RemoveAll.removeAllTasks();

                case "exit":
                    System.out.println("-------------EXITING THE APPLICATION ---------------");
                    scanner.close();
                    System.exit(0);
                default :
                    System.out.println("Invalid command entered ,please, Try Again!");
            }
        }
    }
    public static int getValidInteger(Scanner scanner){
        try{
            int num = Integer.parseInt(scanner.nextLine().trim());
            return num>=0 ? num : -1 ;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input ! , please , try again");
        }
        return -1;
    }
}
