using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FinallyEx
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employ e1=null;
            Employ e2=null;

            try
            {
                e1 = new Employ();
                e1.Empno = 1;
                e1.Name = "Ayush";
                e1.Basic = 83823;

                e2 = new Employ();
                e2.Empno = 3;
                e2.Name = "Priyanshi";
                e2.Basic = 83823;
                Console.WriteLine(e1);
                Console.WriteLine(e2);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
            finally
            {
                e1 = null;
                e2 = null;
            }
        }
    }
}
