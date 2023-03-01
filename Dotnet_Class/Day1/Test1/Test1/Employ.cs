using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test1
{
    internal class Employ
    {
        internal int empno;
        internal string name;
        internal double basic;

        public override string ToString()
        {
            return "Employ No  " + empno + " Name  " + name + " Basic  " + basic;
        }
    }
}
