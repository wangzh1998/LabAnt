public class PlayRoom {

    //下面的很多静态类应该修改，将PlayRoom在UI类中实例化，很多静态属性改掉



    //add 以下
    private  Ant[] ants; //每次要重新进行new 要把antVelocity赋予Ant类中的静态属性velocity
    private  Stick stick;
    private  int totalSituations=0;
    private  Direction[][] directions;
    private  float[] timeRecords;


    private  float incTime;
    //private int[] timeRecord;
    private int antVelocity ;
    private  int antNum ;
    private  float[] initAntPositions ;
    private int stickLength;

    public PlayRoom(float incTime, int antVelocity, int antNum, float[] initAntPositions, int stickLength) {
        this.incTime = incTime;
        this.antVelocity = antVelocity;
        this.antNum = antNum;
        this.initAntPositions = initAntPositions;
        this.stickLength = stickLength;
    }

    //根据蚂蚁数据计算总共有多少种情况，并将每种情况下，不同蚂蚁的初始方向放入directions数组中
    public  void buildDirections()
    {
         totalSituations = 2<<(antNum-1);
         directions =  new Direction[totalSituations][antNum];

         for(int k=0;k<totalSituations;k++){
             int s_k = k;
             for(int i=antNum-1;i>=0;i--){
                if(s_k%2==0)directions[k][i]=Direction.left;
                else directions[k][i]=Direction.right;
                s_k=s_k>>1;
             }
         }
         //System.out.println(totalSituations);
    }

    public  void playAllGames()
    {
        stick = new Stick(stickLength);
        timeRecords = new float[totalSituations];
        float last_cur_time = 0.0f;

        for(int i=0;i<totalSituations;i++){//每一个i代表一种初始方向的一轮游戏，每次需要重新new蚂蚁

            System.out.println("\n\n\n------------------Situantion "+(i+1)+"----------------");

            ants = new Ant[antNum];
            for(int j=0;j<antNum;j++)
                ants[j]=new Ant(initAntPositions[j],directions[i][j]);
            ants[0].setVelocity(antVelocity);
            CreepingGame.playOneGame(incTime,antNum,ants,stick);

            //纪录时间
            timeRecords[i] = CreepingGame.curTime-last_cur_time;
            last_cur_time = CreepingGame.curTime;
            System.out.println("\ntimeRecord["+i+"]"+timeRecords[i]);
        }
    }

    public  float findMinTime(){
        float time = timeRecords[0];
        for(int i=1;i<timeRecords.length;i++){
            if(timeRecords[i]<time)
                time=timeRecords[i];
        }
        return time;
    }

    public  float findMaxTime(){
        float time = timeRecords[0];
        for(int i=1;i<timeRecords.length;i++){
            if(timeRecords[i]>time)
                time=timeRecords[i];
        }
        return time;
    }

    /*public void configure()//该方法从PlayRoom中移出，放入UI类中
    {

    }*/

    /*public static void main(String args[])
    {

    }*/
}

