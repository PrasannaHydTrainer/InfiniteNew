using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StExample
{
    internal class Demo
    {
        static int x;
        public void Increment()
        {
            x++;
            Console.WriteLine("X value is  " +x);
        }
        static void Main(string[] args)
        {
            Demo obj1 = new Demo();
            Demo obj2 = new Demo();
            Demo obj3 = new Demo();
            obj1.Increment();
            obj2.Increment();
            obj3.Increment();
        }
    }
}
