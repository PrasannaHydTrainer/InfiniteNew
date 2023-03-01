using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoxDemo
{
    internal class Demo
    {
        static void Main(string[] args)
        {
            int x = 12;
            string str = "Welcome";
            double basic = 83234.42;

            // Implement Boxing 

            object ob1 = x;
            object ob2 = str;
            object ob3 = basic; 

            // Implement Unboxing 
            int x1 = (Int32)ob1;
            string s1 = (string)ob2;
            double d1 = (double)ob3;
            Console.WriteLine(x1);
            Console.WriteLine(s1);
            Console.WriteLine(d1);
        }
    }
}
