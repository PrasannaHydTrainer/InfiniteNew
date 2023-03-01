using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExtnEx
{
    internal static class ExtnEx
    {
        public static int Mult(this Calculation calc, int a, int b)
        {
            return a * b;
        }
    }
}
