using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StConEx
{
    internal class Demo
    {
        static Demo()
        {
            Console.WriteLine("Static Constructor...");
        }

        Demo()
        {
            Console.WriteLine("Defeault Constructor...");
        }
        static void Main(string[] args)
        {
            Demo obj = new Demo();

        }
    }
}
