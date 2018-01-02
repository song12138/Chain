package visitor;

import visitor.department.FADepartment;
import visitor.department.HRDepartment;
import visitor.emplyee.Employee;
import visitor.emplyee.GeneralEmployee;
import visitor.emplyee.ManagerEmployee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2017/11/27.
 */
public class Client {
    public static void main(String [] args){
        List<Employee> employeeList = new ArrayList<>();

        Employee mep1,mep2,gep1,gep2,gep3;
        // 管理者1
        mep1 = new ManagerEmployee("王总", 8, 20000, 10);
        // 管理者2
        mep2 = new ManagerEmployee("谢经理", 8, 15000, 15);
        // 普通员工1
        gep1 = new GeneralEmployee("小杰", 8, 8000, 8);
        // 普通员工2
        gep2 = new GeneralEmployee("小晓", 8, 8500, 12);
        // 普通员工3
        gep3 = new GeneralEmployee("小虎", 8, 7500, 0);

        employeeList.add(mep1);
        employeeList.add(mep2);
        employeeList.add(gep1);
        employeeList.add(gep2);
        employeeList.add(gep3);


        // 财务部 对公司员工的工资核算/访问
        FADepartment department = new FADepartment();

        HRDepartment department2 = new HRDepartment();

        for (Employee employee : employeeList) {
            employee.accept(department);
        }
        for (Employee employee : employeeList) {
            employee.accept(department2);
        }


        /**
         * 自己的理解：department 访问者 employee 被访问者
         * 1，创建特定的department
         * 2，就是将department对象传入employee对象，然后会自动根据employee对象，自动选择同名重载方法
         */

    }

}
