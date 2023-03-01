using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParamDemo
{
    internal class Demo
    {
        public static void Show(params string[] name)
        {
            foreach(string s in name)
            {
                Console.Write(s + "  ");
            }
            Console.WriteLine();
        }
        static void Main(string[] args)
        {
            Show();
            Show("Ayush");
            Show("Harsh", "Ankit", "Ayush");
        }
    }
}
