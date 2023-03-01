using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OverloadEx2
{
    internal class Demo
    {
        public int Sum()
        {
            return 5;
        }

        public int Sum(int x)
        {
            return x + 5;
        }

        public int Sum(int x, int y)
        {
            return x + y;
        }

        static void Main(string[] args)
        {
            Demo demo = new Demo();
            Console.WriteLine(demo.Sum());
            Console.WriteLine(demo.Sum(42));
            Console.WriteLine(demo.Sum(42,66));
        }
    }
}
