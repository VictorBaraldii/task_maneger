import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        DatabaseMenager dbManager = new DatabaseMenager();
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nGerenciamento de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();
                    System.out.print("Data de Vencimento (yyyy-mm-dd");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Prioridade: ");
                    String priority = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();

                    Task newTask = new Task(title,  description, dueDate,priority, status);
                    dbManager.addTask(newTask);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;


                case "2":
                    System.out.println("Tarefas:");
                    for (Task task : dbManager.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case "3":
                    System.out.print("ID da Tarefa a ser atualizada: ");
                    int taskId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Novo Título: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Nova Descrição: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Nova Data de Vencimento: ");
                    LocalDate newDueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nova Prioridade: ");
                    String newPriority = scanner.nextLine();
                    System.out.print("Novo Status: ");
                    String newStatus = scanner.nextLine();

                    Task updateTask = new Task(taskId, newTitle, newDescription, newDueDate, newPriority, newStatus);
                    dbManager.updateTask(updateTask);
                    System.out.println("Tarefa atualizada com sucesso!");
                    break;

                case "4":
                    System.out.print("ID Tarefa a ser removida: ");
                    int removeTaskId = Integer.parseInt(scanner.nextLine());
                    dbManager.removeTask(removeTaskId);
                    System.out.println("Tarefa removida com sucesso!");
                    break;

                case "5":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        } while (choice.equals("5"));

        scanner.close();
    }
}
