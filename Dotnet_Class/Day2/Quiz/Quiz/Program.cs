using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Data obj = new Data();
            //obj.nam
            IOne obj1 = new Data();
            obj1.Name();

            ITwo obj2 = new Data();
            obj2.Name();

            IThree obj3 = new Data();
            obj3.Name();
        }
    }
}
