class Employee {
    int employeeId; String name; String position; double salary;
    Employee(int id,String name,String position,double salary){
        this.employeeId=id; this.name=name; this.position=position; this.salary=salary;
    }
}

public class EmployeeManagement {
    Employee[] employees=new Employee[100];
    int count=0;

    void addEmployee(Employee e){ employees[count++]=e; }

    Employee searchEmployee(int id){
        for(int i=0;i<count;i++) if(employees[i].employeeId==id) return employees[i];
        return null;
    }

    void deleteEmployee(int id){
        for(int i=0;i<count;i++){
            if(employees[i].employeeId==id){
                for(int j=i;j<count-1;j++) employees[j]=employees[j+1];
                count--; break;
            }
        }
    }
}