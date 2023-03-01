using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace clsAccessModifiers
{
    public class Test : Demo
    {
        public void Display()
        {
            Test obj = new Test();
            Console.WriteLine(obj.trainer);
            Console.WriteLine(obj.mode);
            Console.WriteLine(obj.state);
            Console.WriteLine(obj.venue);
            
        }
    }
}
