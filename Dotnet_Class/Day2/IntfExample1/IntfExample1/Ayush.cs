using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntfExample1
{
    internal class Ayush : ITraining
    {
        public void Email()
        {
            Console.WriteLine("Email is Ayush@gmail.com");
        }

        public void Name()
        {
            Console.WriteLine("Name is Ayush...");
        }
    }
}
