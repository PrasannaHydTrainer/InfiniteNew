using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OutExample1
{
    internal class Demo
    {
        public void Show(int empno, out string name, out double salary)
        {
            if (empno==1)
            {
                name = "Ayush";
                salary = 88234;
            } else if (empno==3)
            {
                name = "Ashish";
                salary = 82244;
            } else
            {
                name = String.Empty;
                salary = 0;
            }
        }
        static void Main(string[] args)
        {
            int empno = 3;
            string name;
            double salary;
            Demo obj = new Demo();
            obj.Show(empno, out name, out salary);
            Console.WriteLine("Name is   " +name);
            Console.WriteLine("Salary is  " +salary );
        }
    }
}
