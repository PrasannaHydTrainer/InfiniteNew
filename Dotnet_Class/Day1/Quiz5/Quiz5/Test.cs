using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz5
{
    internal class Test
    {
        public void Show(int x)
        {
            Console.WriteLine("Show Method w.r.t. Integer  " +x);
        }

        public void Show(object x)
        {
            Console.WriteLine("Show method w.r.t. Object  " +x);
        }
        static void Main(string[] args)
        {
            char ch = 'A';
            Test obj = new Test();
            obj.Show(ch);
        }
    }
}
