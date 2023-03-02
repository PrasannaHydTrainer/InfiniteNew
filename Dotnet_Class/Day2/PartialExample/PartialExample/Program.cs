using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PartialExample
{
    internal partial class Employ
    {
        public void Show()
        {
            Console.WriteLine("Dotnet Training is Going On...");
        }
        public override string ToString()
        {
            return "Employ No  " + empno + " Name  " + name + " Basic  " + basic;
        }

    }
    internal class Program
    {
        static void Main(string[] args)
        {
            Employ employ = new Employ(1, "Ayush",77324);
            Console.WriteLine(employ);
            employ.Show();
        }
    }
}
