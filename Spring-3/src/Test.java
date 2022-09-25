
// 车类
class Car {

    private CarBody carBody;

    public Car(CarBody carBody){
        this.carBody = carBody;
    }

    public void createCarSuccess(){
        carBody.createCarSuccess();
    }
}

// 车身类
class CarBody{

    private Chassis chassis;

    public CarBody(Chassis chassis){
        this.chassis = chassis;
    }
    public void createCarSuccess(){
        chassis.createCarSuccess();
    }
}

// 底盘类
class Chassis{

    private Wheel wheel;

    public Chassis(Wheel wheel){
        this.wheel = wheel;
    }

    public void createCarSuccess(){
        wheel.createCarSuccess();
    }
}

// 轮子类
class Wheel{
    private int size = 20;

    // 相当于用户可以自定义网站了
    public Wheel(int size){
        this.size = size;
    }

    public void createCarSuccess(){
        System.out.println("轮子大小："+size);
    }
}

public class Test {
    public static void main(String[] args) {
        // 将需要的部件都准备好（这些就相当于交给了IOC容器，也就是Spring）
        Wheel wheel = new Wheel(100);
        Chassis chassis = new Chassis(wheel);
        CarBody carBody = new CarBody(chassis);
        Car car = new Car(carBody);


        // 最后创建车
        car.createCarSuccess();
    }
}
