import java.util.Scanner;
public class RunBusiness { 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Taxi tax=new Taxi();
        int day=1;
        Time tim[]={new Time(),new Time(7,10,0),new Time(12,5,0),new Time(17,20,0)};
        tax.SetHighTime(tim[1],tim[2],tim[3]);
        System.out.println("day 0, driver have "+tax.GetMoney()+" money  and "+tax.GetOil()+" oil.\n");
        while(true){
            tim[0].SetTime(6,40,0);
            while(tim[0].GetTimeCode()<21){
                tim[0].PlusMin(17,true);
                System.out.print("day "+day+"  ");
                tim[0].Display();
                tax.SetTime(tim[0]);
                tax.run();
                System.out.println(" ");
                if(!tax.GetLife()){
                    break;
                }
            }
            System.out.println("day "+day+", driver have "+tax.GetMoney()+" moey and "+tax.GetOil()+" oil.\n\npress \"Enter\" to start next day.\nor press \"Ctrl\"+\"C\" to have a rest.\n");
            sc.nextLine();
            day++;
        }
    }
}
