package visitor.department;

import visitor.emplyee.GeneralEmployee;
import visitor.emplyee.ManagerEmployee;

/**具体访问者对象：公司财务部<br/>
 * 财务部的职责就是负责统计核算员工的工资
 * Created by paul on 2017/11/27.
 */
public class FADepartment extends Department {
    /**
     * 访问公司管理者对象的每月工资
     * @param managerEmployee
     */
    @Override
    public void visit(ManagerEmployee managerEmployee) {
        double totalWage = managerEmployee.getTotalWage();
        System.out.println("管理者: " + managerEmployee.getName() +
                "  固定工资 =" + managerEmployee.getWage() +
                ", 迟到时长 " + managerEmployee.getPunishmentTime() + "小时"+
                ", 实发工资="+totalWage);
    }

    /**
     * 访问公司普通员工对象的每月工资
     * @param ge
     */
    @Override
    public void visit(GeneralEmployee ge) {
        double totalWage = ge.getTotalWage();
        System.out.println("普通员工: " + ge.getName() +
                "  固定工资 =" + ge.getWage() +
                ", 迟到时长 " + ge.getPunishmentTime() + "小时"+
                ", 实发工资="+totalWage);
    }
}
