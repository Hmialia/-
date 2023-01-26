public class Time {
    private int hour;
    private int min;
    private int sec;
    public Time(){};
    public Time(int a,int b,int c){
        hour=a;min=b;sec=c;
    }
    public void SetTime(int h,int m,int s){
        hour=h;min=m;sec=s;
    }
    public void Display(){
        if(hour<10){
            System.out.print("0");
        }
        System.out.print(hour+":");
        if(min<10){
            System.out.print("0");
        }
        System.out.print(min+":");
        if(sec<10){
            System.out.print("0");
        }
        System.out.println(sec);
    }
    public void PlusMin(int x,boolean y){
        if(y){
            sec+=(int)Math.floor(Math.random()*360);
        }
        if(sec>59){
            min+=sec/60;
            sec=sec%60;
        }
        if(x>2){
            x-=3;
        }
        min+=x;
        if(min>59){
            hour+=min/60;
            min=min%60;
        }
        if(hour>23){
            hour=hour%24;
        }
    }
    public double GetTimeCode(){
        double code=hour+(double)min/60;
        return code;
    }
}

