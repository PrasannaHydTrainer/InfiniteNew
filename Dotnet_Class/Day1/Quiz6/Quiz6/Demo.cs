using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz6
{
    internal class Demo
    {
        public void Show(int x)
        {
            Console.WriteLine("Show Method w.r.t. Integer  " +x);
        }

        public void Show(object x)
        {
            Console.WriteLine("Show Method w.r.t. Object  " +x);
        }

        static void Main(string[] args)
        {
            Demo obj = new Demo();
            obj.Show(12.5);
        }
    }
}
