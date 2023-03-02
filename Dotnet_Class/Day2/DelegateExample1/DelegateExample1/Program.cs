using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateExample1
{
    internal class Program
    {
        public delegate void Delegate1(string s);

        public static void Show(string s)
        {
            Console.WriteLine("Name is  " +s);
        }

        static void Main(string[] args)
        {
            Delegate1 obj = new Delegate1(Show);
            obj("Ayush");
        }
    }
}
