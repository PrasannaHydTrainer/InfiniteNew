using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventExample
{
    internal class Program
    {
        public delegate void EventDemo();
        public static event EventDemo ShowInfo;

        public static void Ayush()
        {
            Console.WriteLine("Hi I am Ayush...");
        }

        public static void Maithreya()
        {
            Console.WriteLine("Hi I am Maithreya...");
        }

        public static void Ashish()
        {
            Console.WriteLine("Hi I am Ashish...");
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Enter your Name   ");
            string name = Console.ReadLine();
            
            if (name.Equals("Ayush"))
            {
                ShowInfo = new EventDemo(Ayush);
                ShowInfo.Invoke();
            }

            if (name.Equals("Maithreya"))
            {
                ShowInfo = new EventDemo(Maithreya);
                ShowInfo.Invoke();
            }

            if (name.Equals("Ashish"))
            {
                ShowInfo = new EventDemo(Ashish);
                ShowInfo.Invoke();
            }
        }
    }
}
