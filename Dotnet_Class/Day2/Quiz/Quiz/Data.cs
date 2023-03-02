using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Quiz
{
    internal class Data : IOne, ITwo, IThree
    {
        void IOne.Name()
        {
            Console.WriteLine("Name from IOne Interface...");
        }

        void ITwo.Name()
        {
            Console.WriteLine("Name from ITwo Interface...");
        }

        void IThree.Name()
        {
            Console.WriteLine("Name from IThree Interface...");
        }
    }
}
