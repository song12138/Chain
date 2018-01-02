package observer;

/**
 * Created by paul on 2017/11/30.
 */
public class Test {
    public static void main(String[] args) {
        TeacherSubject teacher=new TeacherSubject();
        Observer zhangSan=new SudentObserver("张三", teacher);
        Observer LiSi=new SudentObserver("李四", teacher);
        Observer WangWu=new SudentObserver("王五", teacher);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
    }
}
