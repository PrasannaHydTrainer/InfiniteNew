using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AnonymousExample
{
    internal class Program
    {
        public delegate void Show(string name);
        static void Main(string[] args)
        {
            Show obj = delegate (string str)
            {
                Console.WriteLine("This is Anonymous Method  " + str);
            };
            obj("Ayush");
        }
    }
}
