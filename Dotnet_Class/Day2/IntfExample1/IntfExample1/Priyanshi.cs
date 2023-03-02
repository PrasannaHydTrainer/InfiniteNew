using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntfExample1
{
    internal class Priyanshi : ITraining
    {
        public void Email()
        {
            Console.WriteLine("Email is priyanshi@gmail.com");
        }

        public void Name()
        {
            Console.WriteLine("Name is Priyanshi...");
        }
    }
}
