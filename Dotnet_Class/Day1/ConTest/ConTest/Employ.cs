using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConTest
{
    internal class Employ
    {
        int empno;
        string name;
        double basic;

        public Employ() { 
            empno = 1;
            name = "Harsh";
            basic = 84234.33;
        }
        public Employ(int empno, string name, double basic)
        {
            this.empno = empno;
            this.name = name;
            this.basic = basic;
        }

        public override string ToString()
        {
            return "Employ No  " + empno + " Name  " + name + " Basic  " + basic;
        }
    }
}
