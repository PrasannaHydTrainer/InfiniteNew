using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ShadowExample
{
    public class Second : First
    {
        public new  void Show()
        {
            Console.WriteLine("Show Method from Class Second...");
        }
    }
}
