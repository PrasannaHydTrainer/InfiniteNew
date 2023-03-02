using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SealNew
{
    public abstract class Test
    {
        public void Show()
        {
            Console.WriteLine("Hi");
        }
    }
    public class Hello : Test
    {
        public override sealed void Show()
        {

        }
    }

    public class Hi : Hello
    {
        
    }
}
