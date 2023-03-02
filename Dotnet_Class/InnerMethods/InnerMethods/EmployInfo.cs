using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InnerMethods
{
    internal class EmployInfo
    {
        static double TotalSalary(params Employ[] employs)
        {
            double total = 0;
            foreach(Employ employ in employs)
            {
                total += employ.Basic;
            }
            return total;
        }

        static void PrintEmployInfo(params Employ[] employs)
        {
            foreach(Employ employ in employs)
            {
                Console.WriteLine(employ);
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
            Console.WriteLine("Total Salary Paid is  " +TotalSalary(arrEmploy));
        }
    }
}
