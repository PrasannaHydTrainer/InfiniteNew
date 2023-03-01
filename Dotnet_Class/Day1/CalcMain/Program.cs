using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using clsCalculation;

namespace CalcMain
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Calculation obj = new Calculation();
            Console.WriteLine("Sum is  " +obj.Sum(12,5));
            Console.WriteLine("Sub is  " +obj.Sub(12,5));
            Console.WriteLine("Mult is  " +obj.Mult(12,5));
        }
    }
}
