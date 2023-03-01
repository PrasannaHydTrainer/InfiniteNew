using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExtnEx
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int a, b, c;
            a = 52;
            b = 17;
            Calculation obj = new Calculation();
            Console.WriteLine(obj.Sum(a, b));
            Console.WriteLine(obj.Sub(a, b));
            Console.WriteLine(obj.Mult(a,b));
        }
    }
}
