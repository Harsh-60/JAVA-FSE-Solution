public class FinancialForecast {
    static double futureValue(double currentValue,double growthRate,int years){
        if(years==0) return currentValue;
        return futureValue(currentValue*(1+growthRate),growthRate,years-1);
    }

    public static void main(String[] args){
        System.out.println(futureValue(10000,0.10,5));
    }
}