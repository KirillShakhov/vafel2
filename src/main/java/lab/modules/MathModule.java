package lab.modules;
import lab.interfaces.IFunc;
import lab.interfaces.ISysFunc;
import lab.models.Point;
import lab.models.ResultSetForSys;
import java.util.ArrayList;
import java.util.Scanner;

public class MathModule {
    public static void execute(IFunc func, IFunc dfunc) {
        //Для нелинейных уравнений
        Scanner scanner = new Scanner(System.in);
        double left = -5, right = 5, eps = 0.001;
        while (true) {
            while (true) {
                System.out.println("Введите точность:");
                eps = Double.parseDouble(scanner.nextLine());
                System.out.println("Введите левую границу:");
                left = Double.parseDouble(scanner.nextLine());
                System.out.println("Введите правую границу:");
                right = Double.parseDouble(scanner.nextLine());

                if (eps > 0 && eps < 1) {
                    break;
                } else {
                    System.out.println("Точность должна быть больше 0 и меньше 1.");
                }
            }
            break;
        }

        ArrayList<Point> points = new ArrayList<>();
        double point1, point2;
        point1 = MathModule.iterMethod(func, eps);
        point2 = MathModule.chordMethod(func, dfunc, left, right, eps);

        System.out.println("Результат метода простых итераций: " + point1);
        System.out.println("Результат метода хорд: " + point2);

        points.add(new Point(point1, 0));
        points.add(new Point(point2, 0));

        new GraphModule(func, points);
    }
    public static void execute(ISysFunc func) {
        // для систем нелинейных уравнений
        Scanner scanner = new Scanner(System.in);
        double eps, x, y;
        while (true) {
            System.out.println("Введите приближение x:");
            x = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите приближение y:");
            y = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите точность:");
            eps = Double.parseDouble(scanner.nextLine());
            if (eps <= 0 || eps >= 1) {
                System.out.println("Точность должна быть больше 0 и меньше 1.");
            }
            else{
                break;
            }
        }
        ArrayList<Point> points = new ArrayList<>();
        ResultSetForSys result = MathModule.iterMethod(func, x, y, eps);
        points.add(result.getPoint());
        result.print();
        new GraphModule(func.getDraw(), points, -10, 10);
    }



    /*
    метод простых итераций предполагает схему
    xk = g(xk-1) где g(x) = x + b*f(x) где b - произвльное число
    */
    static double g(double x, IFunc f)
    {
        return x + 0.1*f.solve(x);
    }
    public static double iterMethod(IFunc func, double eps) {
        double x = 1;
        for(double iter = 1; eps < Math.abs(func.solve(x)); iter++)
        {
//            cout<<"Iteration : "<<setprecision(0)<<iter<<endl;
//            cout<<"x    = "<<x   <<endl;
//            cout<<"g(x) = "<<g(x)<<endl;
//            cout<<"f(x) = "<<f(x)<<endl;
            x = g(x, func);
        }
        return x;
    }

    public static double chordMethod(IFunc function, IFunc dfunction,  double left, double right, double eps) {
        int n=0;
        double x;
        if (function.solve(left)*dfunction.solve(left)<0)
        {
            x = left;
        }
        else
        {
            x = right;
        }
        double counter = 0;
        counter = Math.abs(dfunction.solve(x));
        while  (counter > eps)
        {
            x = x - (function.solve(x) / dfunction.solve(x));
            n += 1;
            counter--;
        }
//        System.out.println("f( " + x  + ") = " + function.solve(x));
//        System.out.println("f1( " + x + ") = " + function.dsolve(x));
        return x;
    }

    public static ResultSetForSys iterMethod(ISysFunc func, double x, double y, double eps) {
        ResultSetForSys result = new ResultSetForSys();
        double x0 = x, y0 = y, d1, d2;
        int i = 1;
        do {
            x = func.g_x(y0);
            y = func.g_y(x0);
            d1 = func.f1(x, y);
            d2 = func.f2(x, y);
            x0 = x;
            y0 = y;
            result.addIter(x, y, Math.abs(d1), Math.abs(d2));
        } while (Math.abs(d1) > eps || Math.abs(d2) > eps);
        result.setPoint(new Point(x, y));
        return result;
    }

    public static boolean pointChecker(double left, double right, double point) {
        return point >= left && point <= right;
    }
}
