using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test1
{
    internal class Demo
    {
        static void Main(string[] args)
        {
            Employ emp1 = new Employ();
            emp1.empno = 1;
            emp1.name = "Ayush";
            emp1.basic = 88323;
            Console.WriteLine(emp1);
        }
    }
}
