using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz4
{
    internal class Demo
    {
        public void Show(double x)
        {
            Console.WriteLine("Show w.r.t. Double  " +x);
        }

        public void Show(object x)
        {
            Console.WriteLine("Show w.r.t. Object  " +x);
        }
        static void Main(string[] args)
        {
            Demo obj = new Demo();
            obj.Show(12);
        }
    }
}
