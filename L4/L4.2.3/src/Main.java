import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        IEmployee engineer = new Engineer();
        engineer.assignTask(new Task());

        try {
            engineer.finishWorkingDay();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        IEmployee chief = new Chief(new Task[] { new Task() });

        try {
            chief.assignTask(new Task());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        chief.finishWorkingDay();
    }
}

class Task {
    boolean isDone = false;
}

interface IEmployee {
    ArrayList<Task> assignedTasks = new ArrayList<>();
    void finishWorkingDay() throws Exception;
    void assignTask(Task task) throws Exception;
}

class Engineer implements IEmployee {
    public Engineer() {
    }

    public Engineer(Task[] tasks) {
        assignedTasks.addAll(List.of(tasks));
    }

    @Override
    public void finishWorkingDay() throws Exception {
        var someTasksNotDoneYet = false;

        for (Task task : assignedTasks) {
            if (!task.isDone) {
                someTasksNotDoneYet = true;

                break;
            }
        }

        if (someTasksNotDoneYet) {
            throw new Exception("Engineer can not finish working day until all tasks are done");
        }

        System.out.println("Engineer finished working day");
    }

    @Override
    public void assignTask(Task task) throws Exception {
        assignedTasks.add(task);
    }
}

class Chief extends Engineer {
    public Chief() {
    }

    public Chief(Task[] tasks) {
        super(tasks);
    }

    @Override
    public void finishWorkingDay() {
        System.out.println("Chief finished working day");
    }

    @Override
    public void assignTask(Task task) throws Exception {
        throw new Exception("Chief can not be assigned with new tasks");
    }

    public void riseOwnSalary() {
        System.out.println("Chief's salary has been risen");
    }
}