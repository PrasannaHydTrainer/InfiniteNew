using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz2
{
    internal class Quiz
    {
        public void Increment(ref int x)
        {
            x++;
        }
        static void Main(string[] args)
        {
            int x = 12;
            Quiz obj1 = new Quiz();
            obj1.Increment(ref x);
            Console.WriteLine("X value is  " +x);
        }
    }
}
