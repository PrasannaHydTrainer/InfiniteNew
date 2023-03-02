using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EnumNew
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Orders obj1 = new Orders();
            obj1.itemName = "Biryani";
            obj1.price = 84234;
            obj1.orderStatus = OrderStatus.PENDING;
            Console.WriteLine(obj1);
        }
    }
}
