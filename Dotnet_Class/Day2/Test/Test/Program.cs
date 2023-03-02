using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            checked
            {
                int v1 = int.MaxValue;
                //    int v2 = int.MinValue;
                Console.WriteLine(v1 + 2);
            }
            
        }
    }
}
