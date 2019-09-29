public class Stick {
    private int leftEnd = 0;
    private int rightEnd;

    public Stick(int rightEnd) { //+ sonstructor
        this.rightEnd = rightEnd;
    }

    public int getStickLength()
    {
        return rightEnd;
    }

    public void setStickLength(int length)
    {
        rightEnd = length;
    }


    //检查一只蚂蚁范围，如果蚂蚁不在Stick内，返回false，若还在，则返回True
    //用于CreepingGame中判断是否允许蚂蚁继续 Creeping
    public boolean checkAntRange(Ant ant){
        if(ant.getPosition() < rightEnd && ant.getPosition() > leftEnd)
            return true;
        return false;
    }


    //检查所有蚂蚁范围，如果所有蚂蚁都不在Stick内，返回false，若有蚂蚁还在Stick内，则返回true
    public boolean checkAllAntRange(Ant[] ants)//+ 改个名字，方便辩识
    {
        for(int i = 0;i < ants.length; i++)
        {
            if(ants[i].getPosition() < rightEnd && ants[i].getPosition() > leftEnd)
                return true;
        }
        return false;
    }

    public int getLeftEnd() {
        return leftEnd;
    }

    public int getRightEnd() {
        return rightEnd;
    }

    public void setLeftEnd(int leftEnd) {
        this.leftEnd = leftEnd;
    }

    public void setRightEnd(int rightEnd) {
        this.rightEnd = rightEnd;
    }
}
