import java.util.Scanner;
import java.util.ArrayList;
class Student{
    int id;
    String name;
    int age;
    String course;
    float marks;
    char grade;
    Student(int id, String name, int age, String course, float marks){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
        this.marks=marks;
    }
    public void Display(){
        if(marks>=90){
            grade='A';
        }else if(marks>=80){
            grade='B';
        }else if(marks>=70){
            grade='C';
        }else if(marks>=60){
            grade='D';
        }else if(marks>=50){
            grade='E';
        }else{
            grade='F';
        }
        System.out.println("====================================================================================================");
        System.out.println("| ID : "+id+" | NAME : "+name+" | AGE : "+age+" | COURSE : "+course+" | MARKS : "+marks+" | STATUS : "+((marks>=50)? "Passed": "Failed")+" | GRADE : "+grade+" |");
        System.out.println("====================================================================================================");
    }
}

public class StudentDataManagement {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();

        while(true){
            System.out.println("===========Students_Menu===========");
            System.out.println("|1. View all Students.            |\n|2. Register new Student.         |\n|3. Exit.                         |");
            System.out.println("===================================");
            System.out.print("Choose an Option:");

            int choice=sc.nextInt();
            switch(choice){
                case 1:
                System.out.print("Enter Student id:");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the Student name:");
                String name=sc.nextLine();
                System.out.print("Enter Student age:");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Student Course name:");
                String course=sc.nextLine();
                System.out.print("Enter Student Marks:");
                float marks=sc.nextFloat();
                students.add(new Student(id, name, age, course, marks));
                System.out.println("Students have been registered successfully choose second option to Review:");
                break;
                case 2:
                System.out.println("All Student are:");
                for(Student data : students){
                 data.Display();
                }
                break;
                case 3:
                System.out.println("Your program Exited SuccessFully!");
                break;
                default:
                System.out.println("Invalid Choice try Again plz!");

            }
        }
    }
}
