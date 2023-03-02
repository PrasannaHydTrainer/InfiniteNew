using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultiInh
{
    internal class Data : IOne, ITwo
    {
        public void Email()
        {
            Console.WriteLine("Email is DotnetTraining@gmail.com");
        }

        public void Name()
        {
            Console.WriteLine("Dotnet Training...");
        }
    }
}
