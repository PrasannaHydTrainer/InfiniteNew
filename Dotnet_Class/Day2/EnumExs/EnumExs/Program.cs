using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EnumExs
{
    enum WeekDays
    {
        SUNDAY, 
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
    internal class Program
    {
        static void Main(string[] args)
        {
            WeekDays wd = WeekDays.THURSDAY;
            Console.WriteLine(wd);
            Console.WriteLine("Enter WeekDay Name  ");
            string name = Console.ReadLine();
            WeekDays wd1 = (WeekDays)Enum.Parse(typeof(WeekDays), name.ToUpper());
            Console.WriteLine(wd1);
        }
    }
}
