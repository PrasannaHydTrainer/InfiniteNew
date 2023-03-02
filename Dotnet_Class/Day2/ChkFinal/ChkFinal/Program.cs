using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChkFinal
{
    internal class Program
    {
        static void Main(string[] args)
        {

            try
            {
                int v1 = int.MaxValue;
                int v2 = int.MaxValue;
                checked
                {
                    Console.WriteLine(v1 * v2);
                }
            }
            catch(OverflowException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
            
        }
    }
}
