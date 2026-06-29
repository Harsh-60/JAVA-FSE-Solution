class Task {
    int taskId; String taskName; String status;
    Task next;
    Task(int id,String name,String status){
        this.taskId=id; this.taskName=name; this.status=status;
    }
}

public class TaskManagement {
    Task head;

    void addTask(int id,String name,String status){
        Task n=new Task(id,name,status);
        if(head==null){ head=n; return; }
        Task t=head;
        while(t.next!=null) t=t.next;
        t.next=n;
    }

    void delete(int id){
        if(head==null) return;
        if(head.taskId==id){ head=head.next; return; }
        Task t=head;
        while(t.next!=null && t.next.taskId!=id) t=t.next;
        if(t.next!=null) t.next=t.next.next;
    }
}