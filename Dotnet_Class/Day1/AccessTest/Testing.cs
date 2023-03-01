using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccessTest
{
    public class Testing
    {
        public void Show()
        {
            clsAccessModifiers.Demo obj = new clsAccessModifiers.Demo();
            Console.WriteLine(obj.trainer);
        }
    }
}
