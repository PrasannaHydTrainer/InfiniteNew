using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OptionalExample
{
    internal class Demo
    {
        public void Calc(int a,  int b=5)
        {
            int c = a + b;
            Console.WriteLine("Sum is  " +c);
        }
        static void Main(string[] args)
        {

            Demo demo = new Demo();
            demo.Calc(23);
            demo.Calc(23, 10);
        }
    }
}
