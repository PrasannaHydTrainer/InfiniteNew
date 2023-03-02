using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntfExample1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ITraining[] arr = new ITraining[]
            {
                new Ayush(),
                new Priyanshi()
            };
            foreach(ITraining i in arr)
            {
                i.Name();
                i.Email();
            }
        }
    }
}
