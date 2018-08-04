/**
 * @author bijia.sun@hand-china.com
 * @date 2018/8/4 10:13
 */
import java.util.Scanner;
class People{
    private double salary; //工资
    private double tax; //税

    public People(double salary){
        this.salary = salary;
    }
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSalary() {
        return salary;
    }
}
enum CaculateTax {          //创建了一个计算个人所得税的类，并且是通过枚举实现单例模式
    INSTANCE;
    public double caculate(double salary) {
        double salaryreal = salary - 3500; //计算含税级距中应纳税所得额
        int level = 0;
        double tax = 0;
        if (salaryreal <= 1500) {
            level = 1;
        } else if (salaryreal <= 4500) {
            level = 2;
        } else if (salaryreal <= 9000) {
            level = 3;
        } else if (salaryreal <= 35000) {
            level = 4;
        } else if (salaryreal <= 55000) {
            level = 5;
        } else if (salaryreal <= 80000) {
            level = 6;
        } else {
            level = 7;
        }
        switch (level) {
            case 1:
                tax = salaryreal * 0.03;
                break;
            case 2:
                tax = 45 + (salaryreal-1500) * 0.1;
                break;
            case 3:
                tax = 45+300 + (salaryreal-4500) * 0.2;
                break;
            case 4:
                tax = 45+300+900 + (salaryreal-9000) * 0.25;
                break;
            case 5:
                tax = 45+300+900+6500+ (salaryreal-35000) * 0.3;
                break;
            case 6:
                tax = 45+300+900+6500+6000 +(salaryreal-55000) * 0.35;
                break;
            case 7:
                tax = 45+300+900+6500+6000+8750 +(salaryreal-80000)* 0.45;
                break;
        }
        return tax;
    }
}
public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入工资:");
        People userA = new People(sc.nextDouble());
        userA.setTax(CaculateTax.INSTANCE.caculate(userA.getSalary()));
        System.out.println("所需要缴纳的税费："+ userA.getTax());
    }
}
