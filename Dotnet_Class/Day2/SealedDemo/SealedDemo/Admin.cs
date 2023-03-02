using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SealedDemo
{
    //static class Xyz
    //{

    //}

    //static class Hi : Object
    //{

    //}
    public sealed class Admin
    {
        public void Show()
        {
            Console.WriteLine("From Admin Class Dotnet...");
        }

        public void Display()
        {
            Console.WriteLine("Some Conferencial Data...");
        }
    }
}
