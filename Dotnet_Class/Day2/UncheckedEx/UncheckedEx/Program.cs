using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UncheckedEx
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int v1 = int.MaxValue;
            int v2 = int.MaxValue;
            int v3 = unchecked( v1 * v2);
            Console.WriteLine(v3);
        }
    }
}
