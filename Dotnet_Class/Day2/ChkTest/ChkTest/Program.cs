using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChkTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //checked
            //{
            //    int v1 = int.MaxValue;
            //    int v2 = int.MaxValue;
            //    Console.WriteLine(v1 * v2);
            //}
            int v1 = int.MaxValue;
            int v2 = int.MaxValue;
            Console.WriteLine(checked( v1 * v2));
        }
    }
}
