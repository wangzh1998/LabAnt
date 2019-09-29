//修改 这个类就是一个工具类，把方法都设置成为Static。把属性都取消，当作参数传进方法中
public class CreepingGame {

    public static float curTime;//? 这个属性纪录当前时间.静态类型。

    //add 要加上一个参数,int incTime
    //delete private boolean isGameEnd;//? 这个属性干吗用的？不需要。只需要一个这样的局部变量即可。
    //private int antNum;
    //private Ant[] ants;  //Ant类数组就可以获取蚂蚁的位置和方向了
    //private Stick stick;


    //在一个配置下，推进一次游戏
    public static void playOneGame(float incTime,int antNum,Ant[] ants,Stick stick)//只有这个方法需要对外可见
    {
        boolean isGameEnd=false;

        //打印
        printOneStep(antNum,ants);

        while(!isGameEnd){

            curTime+=incTime;//时间相关

            drivingGame(antNum,ants,incTime,stick);
            globalCollisionCheck(antNum,ants,stick);

            //打印
            printOneStep(antNum,ants);

            isGameEnd=!stick.checkAllAntRange(ants);
        }

    }

    //推动每个蚂蚁前进一次
    private static void drivingGame(int antNum,Ant[] ants,float incTime,Stick stick)// public -> private
    {
        for(int i=0;i<antNum;i++)
            if(stick.checkAntRange(ants[i])==true)
                ants[i].creeping(incTime);
    }

    //做一次全局检测 从开始到结束，蚂蚁在stick上的顺序是不会变的
    private static void globalCollisionCheck(int antNum,Ant[] ants,Stick stick)// public -> private
    {
        for(int i=0;i<antNum-1;i++){
            if(stick.checkAntRange(ants[i])){////如果蚂蚁还在stick内，才做碰撞检测
                for(int j=0;j<antNum;j++){
                    ants[i].collisionCheck(ants[j]);
                }
            }
        }
    }

    //+ 添加一个方法，每走一步打印所有蚂蚁的位置和方向
    private static void printOneStep(int antNum,Ant[] ants){
        System.out.println("\ncurTime:"+curTime+"s");
        for(int i=0;i<antNum;i++){
            System.out.print(ants[i].getPosition());
            System.out.print(ants[i].getDirection()+" ");
        }
    }



}
