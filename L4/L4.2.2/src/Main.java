public class Main {
    public static void main(String[] args) {
        Student partTimeStudent = new PartTimeStudent();
        Student expelledStudent = new ExpelledStudent();

        System.out.println("Part-time student is enrolled at university: " + partTimeStudent.isEnrolledAt());
        System.out.println("Expelled student is enrolled at university: " + expelledStudent.isEnrolledAt());
    }
}

interface IApplicant {
    boolean isEnrolledAt();
}

abstract class Student implements IApplicant {
    @Override
    public boolean isEnrolledAt(){
        return true;
    }

    public abstract String ConveyHomeworkResults() throws Exception;
}

class PartTimeStudent extends Student {

    @Override
    public String ConveyHomeworkResults() {
        var usedMethod = "Homework results have been sent via e-mail";

        return usedMethod;
    }
}

class ExpelledStudent extends Student {
    @Override
    public boolean isEnrolledAt() {
        return false;
    }

    @Override
    public String ConveyHomeworkResults() throws Exception {
        throw new Exception("Expelled student can not convey homework results");
    }
}