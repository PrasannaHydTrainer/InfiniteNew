using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NamedParams
{
    internal class Demo
    {
        public static void Show(string firstName, string lastName, string state, string city)
        {
            Console.WriteLine("First Name  " +firstName);
            Console.WriteLine("Last Name  " +lastName);
            Console.WriteLine("State  " +state);
            Console.WriteLine("City   " +city);
        }
        static void Main(string[] args)
        {
            //  Show("Pune", "MH", "Ayush", "Gupta");    
            Show(city: "Pune", state: "MH", firstName: "Ayush", lastName: "Gupta");
        }
    }
}
