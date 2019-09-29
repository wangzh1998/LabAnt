public class Ant {
    private static int velocity=0;//static + 默认值为5?
    private float position;//int -> float
    private Direction direction;


    public Ant(float position, Direction direction) {//+
        this.position = position;
        this.direction = direction;
    }

    public void changeDirection()
    {
        if(this.direction == Direction.left)
            this.direction = Direction.right;
        else
            this.direction = Direction.left;
    }

    public void creeping(float incTime)//incTime 从int改成float
    {
        float distance = incTime*velocity;
        if(this.direction == Direction.left)
            position -= distance;
        else
            position += distance;

    }

    //判断当前时刻，该蚂蚁是否与参数蚂蚁相撞.若相撞，则两只蚂蚁分别改变方向。
    public boolean collisionCheck(Ant otherAnt)//+ 加上传入的对象参数
    {
        if(this.position==otherAnt.position&&this.direction==otherAnt.direction){
            this.changeDirection();
            otherAnt.changeDirection();
            return true;
        }
        return false;
    }

    public int getVelocity() {
        return velocity;
    }

    public float getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
