package visitor.department;

import visitor.emplyee.GeneralEmployee;
import visitor.emplyee.ManagerEmployee;

/** 具体访问者对象：公司人力资源部<br/>
 * 人力资源部的职责就是负责统计核算员工的每月上班时长
 * Created by paul on 2017/11/27.
 */
public class HRDepartment extends Department {
    /**
     * 访问公司管理者对象的每月实际上班时长统计
     * @param managerEmployee
     */
    @Override
    public void visit(ManagerEmployee managerEmployee) {

        System.out.println("管理者"+managerEmployee.getTotalTimeSheet());
    }

    /**
     * 访问公司普通员工对象的每月实际上班时长统计
     * @param ge
     */
    @Override
    public void visit(GeneralEmployee ge) {
        System.out.println("普通员工"+ge.getTotalTimeSheet());
    }
}
