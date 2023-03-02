using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbsConEx
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employ[] arr = new Employ[]
            {
                new Harsh(1, "Harsh", 84823.44),
                new Maitreyi(3, "Maithreyi", 84245.32)
            };
            foreach(Employ e in arr)
            {
                Console.WriteLine(e);
            }
        }
    }
}
