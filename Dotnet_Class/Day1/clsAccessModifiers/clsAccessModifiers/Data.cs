using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace clsAccessModifiers
{
    public class Data
    {
        public void Show()
        {
            Demo obj = new Demo();
            Console.WriteLine(obj.trainer);
            Console.WriteLine(obj.venue);
            Console.WriteLine(obj.state);
        }
    }
}
