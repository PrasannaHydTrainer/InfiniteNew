using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OverloadEx1
{
    internal class Demo
    {
        public void Show(int x)
        {
            Console.WriteLine("Show Method w.r.t. Integer  " +x);
        }

        public void Show(double x)
        {
            Console.WriteLine("Show Method w.r.t. Double   " +x);
        }

        public void Show(string x)
        {
            Console.WriteLine("Show Method w.r.t. String  " +x);
        }
        static void Main(string[] args)
        {
            Demo obj = new Demo();
            obj.Show(12);
            obj.Show(12.5);
            obj.Show("Dotnet");
        }
    }
}
