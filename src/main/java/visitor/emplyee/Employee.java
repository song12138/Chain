package visitor.emplyee;

import visitor.department.Department;

/**
 * 公司员工（被访问者）抽象类
 * Created by paul on 2017/11/27.
 */
public abstract class Employee {

    /**
     * 接收/引用一个访问者对象，抽象访问者 这里指的是公司部门如 人力资源部、财务部
     */
    public abstract void accept(Department department);
}
