using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoxRuntime
{
    internal class Demo
    {
        public void Show(object ob)
        {
            string str = ob.GetType().Name;
            Console.WriteLine(str);
            if (str.Equals("Int32"))
            {
                int x = (Int32)ob;
                Console.WriteLine("Integer Casting..." +x);
 
            }
            if (str.Equals("Double"))
            {
                double x = (Double)ob;
                Console.WriteLine("Double Casting..." +x);
            }
            if (str.Equals("String"))
            {
                string x = (String)ob;
                Console.WriteLine("String Casting...");
            }
        }
        static void Main(string[] args)
        {
            int x = 12;
            string str = "Welcome";
            double basic = 45234.55;
            Demo obj = new Demo();
            obj.Show(x);
            obj.Show(str);
            obj.Show(basic);
        }
    }
}
