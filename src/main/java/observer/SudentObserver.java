package observer;

/**
 * Created by paul on 2017/11/30.
 */
public class SudentObserver implements Observer {

    //保存一个Subject的引用,以后如果可以想取消订阅,有了这个引用会比较方便
    private TeacherSubject t;
    //学生的姓名,用来标识不同的学生对象
    private String name;


    //构造器用来注册观察者
    public SudentObserver(String name,TeacherSubject t) {
        this.name=name;
        this.t = t;
        //每新建一个学生对象,默认添加到观察者的行列
        t.registObserver(this);
    }

    @Override
    public void updata(String msg) {
        System.out.println(name+"得到作业:"+msg);
    }
}
