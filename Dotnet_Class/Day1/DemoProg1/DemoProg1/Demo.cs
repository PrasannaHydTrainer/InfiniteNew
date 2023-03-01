using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoProg1
{
    /// <summary>
    /// Demo class that contains access modifier methods. 
    /// </summary>
    internal class Demo
    {
        public void SayHello()
        {
            Console.WriteLine("Welcome to C# Programming...");
        }

        internal void Trainer()
        {
            Console.WriteLine("Trainer Name is Mr. Prasanna Pappu...");
        }

        private void City()
        {
            Console.WriteLine("Hi From Hyderabad...");
        }
    }
}
