import java.util.*;

class Product {
    int productId; String productName; String category;
    Product(int id,String name,String category){
        this.productId=id; this.productName=name; this.category=category;
    }
}

public class ProductSearch {
    static Product linearSearch(Product[] products,String name){
        for(Product p:products) if(p.productName.equalsIgnoreCase(name)) return p;
        return null;
    }

    static Product binarySearch(Product[] products,String name){
        int low=0, high=products.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int cmp=products[mid].productName.compareToIgnoreCase(name);
            if(cmp==0) return products[mid];
            else if(cmp<0) low=mid+1;
            else high=mid-1;
        }
        return null;
    }

    public static void main(String[] args){}
}