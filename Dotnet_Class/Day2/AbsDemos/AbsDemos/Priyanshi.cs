using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbsDemos
{
    public class Priyanshi : Training
    {
        public override void Email()
        {
            Console.WriteLine("Email is priyanshi@gmail.com");
        }

        public override void Name()
        {
            Console.WriteLine("Name is Priyanshi");
        }
    }
}
