using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbsDemos
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Training[] arr = new Training[]
            {
                new Ayush(),
                new Ashish(),
                new Priyanshi()
            };
            foreach(Training t in arr)
            {
                t.Name();
                t.Email();
            }
        }
    }
}
