using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EnumNew
{
    internal class Orders
    {
        public string itemName;
        public double price;
        public OrderStatus orderStatus;


        public override string ToString()
        {
            return "Item Name " + itemName + " Price  " + price + " Status  " + orderStatus;
        }
    }
}
