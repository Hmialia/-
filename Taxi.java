public class Taxi{
    private int existpeople=0;
    private int oil=100;
    private int place=0;
    private int direction=1;
    private int money=1000;
    private boolean life=true;
    private Time CurrentTime;
    private Time HighTime1;
    private Time HighTime2;
    private Time HighTime3;
    private double k=1;

    public boolean GetLife(){
        return life;
    }
    public int GetOil(){
        return oil;
    }
    public int GetMoney(){
        return money;
    }
    public void SetHighTime(Time a,Time b,Time c){
        HighTime1=a;HighTime2=b;HighTime3=c;
    }
    public void SetTime(Time b){
        CurrentTime=b;
    }
    public void run(){
        //----------------------------------------------------
        place+=direction;
        if(place>10){
            direction*=-1;
            place=9;
            System.out.print("turn round at place 10 and ");
        }
        else if(place<0){
            direction*=-1;
            place=1;
            System.out.print("turn round at place 0 and ");
        }
        if(direction==1){
            System.out.print("go East to place "+place);
        }
        else{
            System.out.print("go West to place "+place);
        }
        if(existpeople!=0){
            System.out.println(" with "+existpeople+" people.");
        }
        else {
            System.out.println(" with an empty car.");
        }
        //--------------------------------------------------
        oil-=3;
        if(oil<20&&(place==3||place==8)){
            int addoil=100-oil;
            int costmoney=addoil*3;
            money-=costmoney;
            if(money<0){
                System.out.println("The Driver do not have enough money to afford the oil and give up.");
                life=false;
            }
            else{
                oil=100;
                System.out.println("add "+addoil+" oil costing "+costmoney+" money.");
            }
        }
        //---------------------------------------------------
        double c=CurrentTime.GetTimeCode();
        double h1=HighTime1.GetTimeCode();
        double h2=HighTime2.GetTimeCode();
        double h3=HighTime3.GetTimeCode();
        if(c<(h1+h2)/2){
            k=Math.cos(c-h1)+1;
        }
        else if(c<(h2+h3)/2){
            k=Math.cos(c-h2)+1;
        }
        else {
            k=Math.cos(c-h3)+1;
        }
        //---------------------------------------------------
        int outpeople=(int)Math.floor(Math.random()*existpeople);
        if(outpeople==0){
            System.out.println("no one get out the Taxi.");
        }
        else {
            existpeople-=outpeople;
            int earnmoney=outpeople*16;
            money+=earnmoney;
            System.out.println(outpeople+" people get out the Taxi. Draver earn "+earnmoney+" money.");
        }
        //---------------------------------------------------
        int inpeople;
        double inchance=Math.random();
        if(inchance<0.05*k){
            inpeople=4;
        }
        else if(inchance<0.2*k){
            inpeople=3;
        }
        else if(inchance<0.4*k){
            inpeople=2;
        }
        else if(inchance<0.5*k){
            inpeople=1;
        }
        else {
            inpeople=0;
        }
        if(inpeople==0){
            System.out.println("no one get in the Taxi.");
        }
        else if(4-existpeople>=inpeople){
            existpeople+=inpeople;
            System.out.println(inpeople+" people get in the Taxi.");
        }
        else if(4-existpeople<inpeople){
            System.out.println(inpeople+" people want to get in the Taxi but have no enough room.");
        }
    }
}
