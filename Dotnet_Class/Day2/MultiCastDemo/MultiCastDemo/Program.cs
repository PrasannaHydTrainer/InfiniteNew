using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultiCastDemo
{
    internal class Program
    {
        public delegate void Delegate1(int n);

        public static void PosNeg(int n)
        {
            if (n >= 0)
            {
                Console.WriteLine("Positive Number...");
            } else
            {
                Console.WriteLine("Negative Number...");
            }
        }

        public static void EvenOdd(int n)
        {
            if (n % 2 == 0)
            {
                Console.WriteLine("Even Number...");
            } else
            {
                Console.WriteLine("Odd Number...");
            }
        }

        public static void Fact(int n)
        {
            int f = 1;
            for(int i = 1; i <= n; i++)
            {
                f = f * i;
            }
            Console.WriteLine("Factorial Value  " +f);
        }

        static void Main(string[] args)
        {
            Delegate1 obj = new Delegate1(PosNeg);
            obj += new Delegate1(EvenOdd);
            obj += new Delegate1(Fact);
            obj(7);
        }
    }
}
