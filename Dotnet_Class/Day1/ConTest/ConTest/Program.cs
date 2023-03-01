using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employ emp1 = new Employ();
            Console.WriteLine(emp1);
            Employ emp2 = new Employ(10, "Priyanshi", 84234.33);
            Console.WriteLine(emp2);
        }
    }
}
