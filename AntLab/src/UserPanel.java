import java.util.Scanner;

public class UserPanel {
    //private int curTime;
    //private boolean isGameEnd;

    private static float minTime;
    private static float maxTime;

    //private Ant[] ants;
    //private int stickLength;
    //private Direction[] directions;




    private  static float incTime = 1.0f;
    private static int antVelocity = 5; // 5cm/s
    private  static int antNum = 5;
    private  static float[] initAntPositions = {30,80,110,160,250};
    private static int stickLength = 300;

    //+
    public static PlayRoom playRoom;

    public static void setInformations()
    {
        System.out.println("incTime:"+incTime);
        System.out.println("antVelocity:"+antVelocity);
        System.out.println("antNum:"+antNum);
        System.out.println("initAntPositions:");
        for(int i=0;i<initAntPositions.length;i++)System.out.printf(initAntPositions[i]+" ");
        System.out.println("\nstickLengh:"+stickLength);
        System.out.println("是否要求改变默认配置？0表示否，1表示是。");

        Scanner scanner = new Scanner(System.in);
        int choice  = scanner.nextInt();
        if(choice==0){
            System.out.println("无需改变配置。游戏启动。");
            return;
        }
        else if(choice==1){
            configureByUser(scanner);
        }
        else{
            System.out.println("指令无效。游戏按照默认状态启动。");
            return;
        }

    }

    private static void configureByUser(Scanner scanner){
        System.out.println("请输入新值：");
        System.out.println("incTime:(float)");
        incTime = scanner.nextFloat();
        System.out.println("antVelocity(int):");
        antVelocity = scanner.nextInt();
        System.out.println("antNum(int):");
        antNum = scanner.nextInt();
        System.out.println("initAntPositions(float):");
        initAntPositions = new float[antNum];
        for(int i=0;i<antNum;i++){//需要一些检测
            initAntPositions[i] = scanner.nextFloat();
            System.out.println(initAntPositions[i]);
        }
        System.out.println("\nstickLengh:(int)");
        stickLength = scanner.nextInt();//需要一些检测

    }

    public static void start()
    {
        playRoom = new PlayRoom(incTime,antVelocity,antNum,initAntPositions,stickLength);

        playRoom.buildDirections();
        playRoom.playAllGames();
        minTime=playRoom.findMinTime();
        maxTime=playRoom.findMaxTime();

        System.out.println("\n\nminTime:"+minTime+"s");
        System.out.println("maxTime:"+maxTime+"s");
    }



    public static void main(String[] args) {
        setInformations();
        start();
    }
}
