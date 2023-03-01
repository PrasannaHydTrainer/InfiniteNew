using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaseCon
{
    public class Employ
    {
        int empno;
        string name;
        double basic;

        public Employ(int empno, string name, double basic)
        {
            this.empno = empno;
            this.name = name;
            this.basic = basic;
        }

        public override string ToString()
        {
            return "Employ No " + empno + " Name  " + name + " Basic  " + basic;
        }
    }
}
