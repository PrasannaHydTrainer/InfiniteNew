using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InnerMethods
{
    internal class EmployInnerMethod
    {
        static void PrintEmployInfo(params Employ[] employs)
        {
            double takeHome;
            foreach (Employ employ in employs)
            {
                takeHome = employ.Basic - Tax(employ.Basic);
                Console.WriteLine("Employ No  " + employ.Empno + "Name  " + employ.Name +
                 "Salary  " +employ.Basic + " Tax  " +Tax(employ.Basic) + "Take Home  " +takeHome);


            }

            double Tax(double basic)
            {
                return basic * 0.03;
            }
        }
        static void Main()
        {
            Employ[] arrEmploy = new Employ[]
 {
                new Employ{Empno=1,Name="Ayush",Basic=38244},
                new Employ{Empno=2,Name="Priyanshi",Basic=74843},
                new Employ{Empno=3,Name="Ashish",Basic=88333},
 };
            PrintEmployInfo(arrEmploy);

        }
    }
}
