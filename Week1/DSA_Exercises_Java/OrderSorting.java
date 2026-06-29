class Order {
    int orderId; String customerName; double totalPrice;
    Order(int id,String name,double totalPrice){
        this.orderId=id; this.customerName=name; this.totalPrice=totalPrice;
    }
}

public class OrderSorting {
    static void bubbleSort(Order[] orders){
        for(int i=0;i<orders.length-1;i++)
            for(int j=0;j<orders.length-i-1;j++)
                if(orders[j].totalPrice>orders[j+1].totalPrice){
                    Order t=orders[j]; orders[j]=orders[j+1]; orders[j+1]=t;
                }
    }

    static int partition(Order[] arr,int low,int high){
        double pivot=arr[high].totalPrice;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].totalPrice<pivot){
                i++;
                Order t=arr[i]; arr[i]=arr[j]; arr[j]=t;
            }
        }
        Order t=arr[i+1]; arr[i+1]=arr[high]; arr[high]=t;
        return i+1;
    }

    static void quickSort(Order[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
}